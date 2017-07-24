package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

    private int id;

    private String name;

    private int age;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
