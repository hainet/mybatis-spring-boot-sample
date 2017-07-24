package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Person {

    private int id;

    private String name;

    private int age;

    private Address address;

    private LocalDateTime time;
}
