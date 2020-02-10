package com.service;

import com.Entity.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// ===== @Component
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save (user);
    }

    @Override
    public void update(User user) {
        userDao.update (user);

    }

    @Override
    public User getById(int id) {
        return userDao.getById (id);
    }

    @Override
    public void delete(int id) {
        userDao.delete (id);

    }

    @Override
    public List<User> findAll() {
        return userDao.findAll ();
    }
}
