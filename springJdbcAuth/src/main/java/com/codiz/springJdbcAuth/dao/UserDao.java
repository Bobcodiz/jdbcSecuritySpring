package com.codiz.springJdbcAuth.dao;

import com.codiz.springJdbcAuth.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createUser(UserModel userModel) {
        log.info("request to insert user reached the dao");
        final String query = "insert into newjdbc.users(email,username,password,role,enabled) values(?,?,?,?,?)";
        Object[] user1 = {userModel.getUsername(), userModel.getEmail(),
                userModel.getPassword(), userModel.getRole(), userModel.isEnabled()};

        jdbcTemplate.update(query,user1);
        return null;

    }
}
