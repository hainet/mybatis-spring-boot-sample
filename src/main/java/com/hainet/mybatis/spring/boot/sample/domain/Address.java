package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Data;

@Data
public class Address {

    private int id;

    private String zipCode;

    private State state;
}
