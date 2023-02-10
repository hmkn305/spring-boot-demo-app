package com.example.springbootdemo.mapper;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface UserMapper {

    List<User> getAllUsers();

    User getUser(String email, String password);

    User getUserByEmail(String email);

    void postUser(CreateAccountRequest request);
}
