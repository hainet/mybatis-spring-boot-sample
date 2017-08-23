package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.ConstructorPerson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConstructorPersonMapper {

    List<ConstructorPerson> findAll();
}
