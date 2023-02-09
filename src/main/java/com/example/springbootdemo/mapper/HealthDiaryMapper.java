package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.time.*;
import java.util.*;

@Mapper
public interface HealthDiaryMapper {

    HealthDiary getHealthDiary(Integer userId, LocalDate date);
}
