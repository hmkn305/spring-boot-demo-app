package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.time.*;
import java.util.*;

@Mapper
public interface TrainingMapper {

    List<Training> getTrainingHistory(int userId, LocalDate thisMonday, LocalDate thisSunday);

//    Optional<Training> getTrainingInfo(int userId, LocalDate date, String trainingMenu);

    List<Training> getTimesOfTheMonthByPart(int userId, LocalDate firstDay, LocalDate lastDay);

    void createTrainingInfo(Training training);
}
