package com.hainet.mybatis.spring.boot.sample.domain;

import lombok.Data;

import java.util.List;

@Data
public class DenormalizedPerson {

    private int id;

    private Address address;

    private List<Skill> skills;
}
