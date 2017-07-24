package com.hainet.mybatis.spring.boot.sample;

import com.hainet.mybatis.spring.boot.sample.domain.Address;
import com.hainet.mybatis.spring.boot.sample.domain.Person;
import com.hainet.mybatis.spring.boot.sample.domain.State;
import com.hainet.mybatis.spring.boot.sample.mapper.PersonMapper;
import com.hainet.mybatis.spring.boot.sample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootApplication
public class MybatisSpringBootSampleApplication implements CommandLineRunner {

    private final PersonMapper personMapper;

    private final UserMapper userMapper;

    @Autowired
    public MybatisSpringBootSampleApplication(
            PersonMapper personMapper,
            UserMapper userMapper) {
        this.personMapper = personMapper;
        this.userMapper = userMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootSampleApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        // do something
    }
}