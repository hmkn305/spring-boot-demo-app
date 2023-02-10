package com.example.springbootdemo.controllers.healthDiary.requests;

import lombok.*;
import org.jetbrains.annotations.*;

import java.time.*;

@Data
public class CreateWeightRequest {

    @NotNull
    private int id;

    @NotNull
    private int weight;

    @NotNull
    private LocalDate date;
}
