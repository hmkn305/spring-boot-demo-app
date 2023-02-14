package com.example.springbootdemo.dto;

import lombok.*;

import java.time.*;

@Data
@Builder
public class TrainingOfTheWeekResponse {

    private int userId;
    private String trainingMenu;
    private int times;
    private int reps;
    private LocalDate trainingDate;
    private int theTimesGotoGymInTheWeek;
}
