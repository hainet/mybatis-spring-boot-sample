package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Person {

    private int id;

    private String name;

    private int age;

    private int addressId;

    private String job;

    private LocalDateTime time;

    private String unmappedString;

    private int unmappedInt;

    private boolean unmappedBoolean;
}
