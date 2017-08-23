package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConstructorPerson {

    private int id;

    private String name;

    public ConstructorPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
