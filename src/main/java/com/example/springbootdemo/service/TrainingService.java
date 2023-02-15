package com.example.springbootdemo.service;

import com.example.springbootdemo.controllers.training.trainingOfTheWeekController.*;
import com.example.springbootdemo.entity.*;
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

    public List<TrainingOfTheWeekResponse> getTrainingHistory(int userId) {
        LocalDate today = LocalDate.now();
        LocalDate thisMonday = today.with(DayOfWeek.MONDAY);
        LocalDate thisSunday = today.with(DayOfWeek.SUNDAY);
        List<Training> trainings = trainingMapper.getTrainingHistory(userId, thisMonday, thisSunday);
        Map<LocalDate, List<Training>> trainingOfTheWeek = trainings.stream().collect(Collectors.groupingBy(Training::getTrainingDate));
        return trainingOfTheWeek.entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByKey())
                                .map(x -> TrainingOfTheWeekResponse
                                        .builder()
                                        .trainingDate(x.getKey())
                                        .trainingOfTheWeekDetailList(x.getValue()
                                                                      .stream()
                                                                      .map(training -> TrainingOfTheWeekDetail
                                                                              .builder()
                                                                              .userId(training.getUserId())
                                                                              .trainingMenu(training.getTrainingMenu())
                                                                              .times(training.getTimes())
                                                                              .reps(training.getReps())
                                                                              .build())
                                                                      .collect(Collectors.toList()))
                                        .build())
                                .collect(Collectors.toList());
    }
}
