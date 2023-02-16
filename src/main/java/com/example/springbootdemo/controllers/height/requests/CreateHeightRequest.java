package com.example.springbootdemo.controllers.height.requests;


import lombok.*;
import org.jetbrains.annotations.*;

@Data
public class CreateHeightRequest {

    @NotNull
    private int id;

    @NotNull
    private int height;
}
