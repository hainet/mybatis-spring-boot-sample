package com.hainet.mybatis.spring.boot.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DenormalizedPersonMapperTest {

    @Autowired
    private DenormalizedPersonMapper mapper;

    @Test
    public void findAll() {
        System.out.println(mapper.findAll());
    }

}
