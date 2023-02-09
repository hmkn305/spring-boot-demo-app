package com.example.springbootdemo.dto;

import lombok.*;

@Data
public class UserResponse {

    private int id;
    private int userId;
    private String name;
    private String email;
    private String password;
}
