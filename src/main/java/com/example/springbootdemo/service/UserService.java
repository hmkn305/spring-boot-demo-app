package com.example.springbootdemo.service;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(String email, String password){
        return userMapper.getUser(email, password); }

    public void postUser(CreateAccountRequest request) {
        userMapper.postUser(request);
    }
}
