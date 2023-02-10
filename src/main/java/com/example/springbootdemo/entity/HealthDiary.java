package com.example.springbootdemo.entity;

import lombok.*;

import java.time.*;

@Data
@Builder
public class HealthDiary {

    Integer id;
    Integer userId;
    Integer weight;
    LocalDate distinctDate;
}
