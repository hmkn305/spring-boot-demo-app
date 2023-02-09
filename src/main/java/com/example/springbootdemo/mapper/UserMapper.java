package com.example.springbootdemo.mapper;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface UserMapper {

    User getUser(String email, String password);

    void postUser(CreateAccountRequest request);
}
