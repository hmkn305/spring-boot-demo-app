package com.example.springbootdemo.service;


import com.example.springbootdemo.controllers.height.requests.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.stream.*;

@Service
public class HeightService {

    @Autowired
    HeightMapper heightMapper;

    @Autowired
    HealthDiaryMapper healthDiaryMapper;

    public void postHeightInfo(CreateHeightRequest request) {
        heightMapper.postHeightInfo(Height.builder()
                                          .userId(request.getId())
                                          .height(request.getHeight())
                                          .build());
    }

    public double[] getBMIForThreeMonths(int userId) {
        double heightOfThisMan = (double) heightMapper.getHeightInfo(userId).getHeight()/100;
        System.out.println(heightOfThisMan);
        //今月のその人のBMIを取得
        LocalDate firstDayOfThisMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate lastDayOfThisMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        double averageWeight = healthDiaryMapper.getWeightInfoForMonth(userId, firstDayOfThisMonth, lastDayOfThisMonth)
                                                .stream()
                                                .collect(Collectors.averagingDouble(HealthDiary::getWeight));
        double BMI = Math.floor((averageWeight / Math.pow(heightOfThisMan, 2)) * 10) / 10;
        double[] BMIForThreeMonths = new double[3];
        BMIForThreeMonths[0] = BMI;
        //TODO: 先月と先々月のBMIを取得し、double型の配列に格納。フロントで棒グラフを表示
        return BMIForThreeMonths;
    }
}
