package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    List<Person> findAllResultType();

    List<Person> findAll();

    Person findById(int id);

    int insert(Person person);

    int update(Person person);

    int delete(Person person);
}