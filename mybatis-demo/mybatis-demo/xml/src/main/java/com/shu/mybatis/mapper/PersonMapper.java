package com.shu.mybatis.mapper;

import com.shu.mybatis.entity.Person;

public interface  PersonMapper {
    Person getPersonById(Integer Id);

    void delPersonById(Integer Id);

    void insertOnePerson(Person person);

    void updatePerson(Person person);
}
