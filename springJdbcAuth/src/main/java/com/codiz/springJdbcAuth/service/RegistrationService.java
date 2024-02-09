package com.codiz.springJdbcAuth.service;

import com.codiz.springJdbcAuth.dao.UserDao;
import com.codiz.springJdbcAuth.dto.UserDto;
import com.codiz.springJdbcAuth.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String create(UserDto userDto) {
        UserModel userModel = new UserModel();
        log.info("service is called to insert a new user ");


        userModel.setUsername(userDto.getUsername());
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userModel.setRole("user");
        try {
            log.info("finally creating");
            return userDao.createUser(userModel);
        }catch (Exception e){
            log.error("error occured somewhere");
            return "could not create user";
        }

    }
}
