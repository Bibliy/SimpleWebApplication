package com.dao;

import com.Entity.User;

import java.util.List;
//это нужно чтобы при запуске приложения создался UserDao
public interface UserDao {

    void save(User user);

    void  update(User user);

    User getById(int id);

    void delete(int id);


    List<User> findAll();
}
