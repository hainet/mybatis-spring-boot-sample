package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.Person;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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
            System.out.println(context.getResultObject());
        });
    }

    @Test
    public void findAllCursorTest() {
        for (Person person : mapper.findAllCursor()) {
            System.out.println(person);
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
}
