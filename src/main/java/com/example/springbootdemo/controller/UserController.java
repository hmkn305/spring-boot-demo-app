package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.mapper.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@NotNull @RequestParam("email") String mailAddress,
                                @NotNull @RequestParam("password") String password){
        User user = userMapper.getUser(mailAddress, password);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse doPost(@RequestBody UserRequest userRequest) {

        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        userMapper.insert(user);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);

        return userResponse;
    }
}
