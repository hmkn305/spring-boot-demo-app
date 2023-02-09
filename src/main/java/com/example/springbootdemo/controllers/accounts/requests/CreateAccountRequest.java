package com.example.springbootdemo.controllers.accounts.requests;

import lombok.*;
import org.jetbrains.annotations.*;

@Data
public class CreateAccountRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

}
