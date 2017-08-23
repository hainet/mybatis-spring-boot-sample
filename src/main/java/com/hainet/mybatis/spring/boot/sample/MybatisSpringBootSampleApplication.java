package com.hainet.mybatis.spring.boot.sample;

import com.hainet.mybatis.spring.boot.sample.domain.Person;
import com.hainet.mybatis.spring.boot.sample.mapper.PersonMapper;
import com.hainet.mybatis.spring.boot.sample.mapper.ConstructorPersonMapper;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@SpringBootApplication
public class MybatisSpringBootSampleApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootSampleApplication.class, args);
    }
}
