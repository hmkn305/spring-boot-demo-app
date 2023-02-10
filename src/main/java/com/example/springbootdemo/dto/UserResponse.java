package com.example.springbootdemo.dto;

import com.example.springbootdemo.entity.type.*;
import lombok.*;

@Data
public class UserResponse {

    private int id;
    private String name;
    private String email;
    private String password;
    private SignInErrorType errorType;
}
