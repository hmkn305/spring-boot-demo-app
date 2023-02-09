package com.example.springbootdemo.entity;

import lombok.*;

import java.time.*;

@Data
public class HealthDiary {

    Integer id;

    Integer userId;

    Integer weight;
    LocalDate distinctDate;
}
