package com.codiz.springJdbcAuth.controller;

import com.codiz.springJdbcAuth.dto.UserDto;
import com.codiz.springJdbcAuth.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class RegisterUser {
    @Autowired
    private  RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        log.info("request to register new user");
        return ResponseEntity.ok(registrationService.create(userDto));
    }
}
