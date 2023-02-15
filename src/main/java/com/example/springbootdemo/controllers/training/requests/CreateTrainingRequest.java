package com.example.springbootdemo.controllers.training.requests;


import lombok.*;
import org.jetbrains.annotations.*;

import java.time.*;

@Data
public class CreateTrainingRequest {

    @NotNull
    private int id;

    @NotNull
    private String trainingMenu;

    @NotNull
    private int times;

    @NotNull
    private int reps;

    @NotNull
    private LocalDate date;
}
