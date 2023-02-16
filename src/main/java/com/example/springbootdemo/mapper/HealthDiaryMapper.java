package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.time.*;
import java.util.*;

@Mapper
public interface HealthDiaryMapper {

    Optional<HealthDiary> getHealthDiary(Integer userId, LocalDate distinctDate);

    List<HealthDiary> getWeightInfoForMonth(Integer userId, LocalDate firstDay, LocalDate lastDay);

    int createWeightInfo(HealthDiary healthDiary);

    int updateWeightInfo(HealthDiary healthDiary);
}
