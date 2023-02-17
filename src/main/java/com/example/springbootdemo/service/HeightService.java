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
        double[] BMIForThreeMonths = new double[4];
        for(int i = 0; i < 4 ; i++ ){
           LocalDate theDay = LocalDate.now().minusMonths(i);
           LocalDate firstDayOfTheMonth = theDay.withDayOfMonth(1);
           LocalDate lastDayOfTheMonth = theDay.withDayOfMonth(theDay.lengthOfMonth());
            double averageWeight = healthDiaryMapper.getWeightInfoForMonth(userId, firstDayOfTheMonth, lastDayOfTheMonth)
                                                    .stream()
                                                    .collect(Collectors.averagingDouble(HealthDiary::getWeight));
            double BMI = Math.floor((averageWeight / Math.pow(heightOfThisMan, 2)) * 10) / 10;
            BMIForThreeMonths[i] = BMI;
        }
        return BMIForThreeMonths;
    }
}
