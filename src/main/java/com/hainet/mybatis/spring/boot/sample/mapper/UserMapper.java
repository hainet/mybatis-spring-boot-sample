package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
}
