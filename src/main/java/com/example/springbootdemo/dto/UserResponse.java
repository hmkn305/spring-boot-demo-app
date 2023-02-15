package com.example.springbootdemo.dto;

import lombok.*;

@Data
public class UserResponse {

    private int id;
    private String name;
    private String email;
    private String password;
    private String errorType;
}
