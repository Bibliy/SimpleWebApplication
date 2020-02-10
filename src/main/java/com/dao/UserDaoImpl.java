package com.dao;

import com.Entity.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    public  JdbcTemplate jdbcTemplate;
 //  ТОЖЕ САМОЕ
//    @Autowired    //чтобы наш jdbcTemplate использовать здесь нужно @AUTOWIRED
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name,email,age) VALUES (?,?,?)";
        jdbcTemplate.update (sql,user.getName (),user.getEmail (),user.getAge ());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name=?,email=?,age=? WHERE id=?";
        jdbcTemplate.update (sql,user.getName (),user.getEmail (),user.getAge (),user.getId ());

    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject (sql,new UserMapper (),id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update (sql,id);

    }

    @Override
    public List<User> findAll() {  //описали как достать бин
        String sql = "SELECT * FROM  user";
        return jdbcTemplate.query(sql,new UserMapper());
    }
}
