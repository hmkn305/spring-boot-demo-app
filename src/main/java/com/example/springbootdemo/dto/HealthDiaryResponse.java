package com.example.springbootdemo.dto;

import lombok.*;

import java.time.*;

@Data
public class HealthDiaryResponse {

    private int id;
    private int userId;
    private int weight;
    private LocalDate distinctDate;
}
