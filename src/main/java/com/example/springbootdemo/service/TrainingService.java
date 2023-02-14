package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class TrainingService {

    @Autowired
    TrainingMapper trainingMapper;

    public List<TrainingOfTheWeekResponse> getTrainingHistory(int userId){
        LocalDate today = LocalDate.now();
        LocalDate thisMonday = today.with(DayOfWeek.MONDAY);
        LocalDate thisSunday = today.with(DayOfWeek.SUNDAY);
        System.out.println(userId);
        return trainingMapper.getTrainingHistory(userId, thisMonday, thisSunday)
                .stream()
                .map(x -> TrainingOfTheWeekResponse
                        .builder()
                        .userId(x.getUserId())
                        .trainingMenu(x.getTrainingMenu())
                        .times(x.getTimes())
                        .reps(x.getReps())
                        .trainingDate(x.getTrainingDate())
                        .build())
                .collect(Collectors.toList());
    }
}
