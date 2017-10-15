package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.Person;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonMapperTest {

    @Autowired
    private PersonMapper mapper;

    @Test
    public void findAllTest() {
        for (Person person : mapper.findAll()) {
            System.out.println(person);
        }
    }

    @Test
    public void findAllRowBoundsTest() {
        for (Person person : mapper.findAllRowBounds(new RowBounds(1, 1))) {
            System.out.println(person);
        }
    }

    @Test
    public void findAllResultHandlerTest() {
        mapper.findAllResultHandler(context -> {
            System.out.println(context.getResultCount());
            System.out.println(context.getResultObject());
        });
    }

    @Test
    @Transactional
    public void findAllCursorTest() {
        try (Cursor<Person> people = mapper.findAllCursor()) {
            for (Person person : people) {
                System.out.println(people.getCurrentIndex());
                System.out.println(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void findByIdTest() {
        System.out.println(mapper.findById(1));
    }

    @Test
    public void findByNameAndAgeTest() {
        System.out.println(mapper.findByNameAndAge("hainet", 24));
    }

    @Test
    public void findByNamesTest() {
        System.out.println(mapper.findByNames(Arrays.asList("hainet")));
    }

    @Test
    public void insertTest() {
        Person person = mapper.findById(1);

        mapper.insert(person);
        // selectKey属性によりAUTO_INCREMENTされたID値を取得
        System.out.println(person.getId());

        mapper.findAll().forEach(it -> System.out.println(it));
    }

    @Test
    public void updateTest() {
        Person person = mapper.findById(1);
        person.setName("updated");

        mapper.update(person);

        for (Person updated : mapper.findAll()) {
            System.out.println(updated);
        }
    }

    @Test
    public void deleteTest() {
        mapper.delete(mapper.findById(1));

        for (Person person : mapper.findAll()) {
            System.out.println(person);
        }
    }

    @Test
    @Sql(scripts = "/bulk-insert.sql")
    @Transactional
    public void defaultExecutorTypeReuseTest() {
        // --mybatis.configuration.default-executor-type=reuse
        List<Person> people = mapper.findAll();

        final long start = System.currentTimeMillis();

        for (Person person : people) {
            mapper.findById(person.getId());
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    @Transactional
    public void defaultExecutorTypeBatchTest() {
        // --mybatis.configuration.default-executor-type=batch
        final long start = System.currentTimeMillis();

        for (int i=1; i<=100000; i++) {
            mapper.updateAgeByName("hainet");
        }

        // BATCHモードでは以下のタイミングで更新キューがSQLとして発行される
        // 1. トランザクション終了時
        // 2. SELECT文発行直前
        // 3. @Flushアノテーションが付与されたメソッド実行時
        int updateCount = 0;
        for (int count : mapper.flush().get(0).getUpdateCounts()) {
            updateCount += count;
        }
        System.out.println(updateCount);

        System.out.println(System.currentTimeMillis() - start);
    }
}
