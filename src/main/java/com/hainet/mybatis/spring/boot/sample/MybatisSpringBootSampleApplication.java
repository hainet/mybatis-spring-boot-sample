package com.hainet.mybatis.spring.boot.sample;

import com.hainet.mybatis.spring.boot.sample.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class MybatisSpringBootSampleApplication implements CommandLineRunner {

    private final PersonMapper personMapper;

    @Autowired
    public MybatisSpringBootSampleApplication(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootSampleApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println(personMapper.findAll());
    }
}