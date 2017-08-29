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
        mapper.insert(mapper.findById(1));

        for (Person person : mapper.findAll()) {
            System.out.println(person);
        }
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
    public void defaultExecutorTypeTest() {
        List<Person> people = mapper.findAll();

        // mybatis.configuration.default-executor-type: simple or reuse
        final long start = System.currentTimeMillis();

        for (Person person : people) {
            mapper.findById(person.getId());
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
