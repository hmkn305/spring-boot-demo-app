package com.example.springbootdemo.entity;

import lombok.*;

import java.time.*;

@Data
public class Training {

    Integer id;
    Integer userId;
    String trainingMenu;
    Integer times;
    Integer reps;
    LocalDate trainingDate;
}
