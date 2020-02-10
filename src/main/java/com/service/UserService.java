package com.service;

import com.Entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void  update(User user);

    User getById(int id);

    void delete(int id);

    List<User> findAll();
}
