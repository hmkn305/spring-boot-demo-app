package com.example.springbootdemo.controllers.training.requests;


import lombok.*;
import org.jetbrains.annotations.*;

import java.time.*;

@Data
public class CreateTrainingRequest {

    @NotNull
    private Long id;

    @NotNull
    private String trainingMenu;

    @NotNull
    private Long times;

    @NotNull
    private Long reps;

    @NotNull
    private LocalDate date;
}
