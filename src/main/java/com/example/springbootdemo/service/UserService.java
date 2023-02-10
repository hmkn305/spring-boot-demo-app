package com.example.springbootdemo.service;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.entity.type.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public UserResponse getUser(String mailAddress, String password) {
        boolean isPresent = userMapper.getAllUsers()
                                      .stream()
                                      .anyMatch(x -> x.getEmail().equals(mailAddress));
        if (isPresent) {
            User user = userMapper.getUser(mailAddress, password);
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        } else {
            UserResponse userResponse = new UserResponse();
            userResponse.setErrorType(SignInErrorType.NotRegisteredEmail.getLabel());
            return userResponse;
        }
    }

    public UserResponse postUser(CreateAccountRequest request) {
        boolean isPresent = userMapper.getAllUsers()
                                      .stream()
                                      .anyMatch(x -> x.getEmail().equals(request.getEmail()));
        if (isPresent) {
            UserResponse userResponse = new UserResponse();
            userResponse.setErrorType(SignInErrorType.AlreadyRegisteredEmail.getLabel());
            return userResponse;
        } else {
            userMapper.postUser(request);
            UserResponse userResponse = new UserResponse();
            userResponse.setName(request.getName());
            return userResponse;
        }
    }
}
