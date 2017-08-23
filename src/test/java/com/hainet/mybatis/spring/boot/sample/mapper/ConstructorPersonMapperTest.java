package com.hainet.mybatis.spring.boot.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConstructorPersonMapperTest {

    @Autowired
    private ConstructorPersonMapper constructorPersonMapper;

    @Test
    public void findAllTest() {
        System.out.println(constructorPersonMapper.findAll());
    }

}
