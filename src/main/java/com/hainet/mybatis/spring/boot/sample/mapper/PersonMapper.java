package com.hainet.mybatis.spring.boot.sample.mapper;

import com.hainet.mybatis.spring.boot.sample.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMapper {

    List<Person> findAll();

    List<Person> findAllRowBounds(RowBounds rowBounds);

    void findAllResultHandler(ResultHandler<Person> resultHandler);

    Cursor<Person> findAllCursor();

    Person findById(int id);

    List<Person> findByNameAndAge(@Param("name") String name, @Param("age") int age);

    List<Person> findByNames(List<String> names);

    int insert(Person person);

    int update(Person person);

    int delete(Person person);
}
