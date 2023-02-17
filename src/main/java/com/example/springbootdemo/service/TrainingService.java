package com.example.springbootdemo.service;

import com.example.springbootdemo.controllers.training.requests.*;
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


    public List<TrainingByPartForMonth> getTimesOfTheMonthByPart(int userId) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfTheMonth = today.withDayOfMonth(1);
        LocalDate lastDayOfTheMonth = today.withDayOfMonth(today.lengthOfMonth());
        List<Training> trainings = trainingMapper.getTimesOfTheMonthByPart(userId, firstDayOfTheMonth, lastDayOfTheMonth);
        Map<LocalDate, List<Training>> trainingByPart = trainings.stream().collect(Collectors.groupingBy(Training::getTrainingDate));
        List<TrainingByPartByDate> trainingByPartList = trainingByPart.entrySet()
                                                                      .stream()
                                                                      .sorted(Map.Entry.comparingByKey())
                                                                      .map(x -> TrainingByPartByDate
                                                                              .builder()
                                                                              .trainingDate(x.getKey())
                                                                              .trainingTimesByPart(x.getValue()
                                                                                                    .stream()
                                                                                                    .filter(entry -> entry.getTrainingByPart() != null)
                                                                                                    .findFirst()
                                                                                                    .get().getTrainingByPart())
                                                                              .build()).toList();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (TrainingByPartByDate trainingByPartByDate : trainingByPartList) {
            if (trainingByPartByDate.getTrainingTimesByPart() == 1) {
                count1 += 1;
            } else if (trainingByPartByDate.getTrainingTimesByPart() == 2) {
                count2 += 1;
            } else if (trainingByPartByDate.getTrainingTimesByPart() == 3) {
                count3 += 1;
            } else {
                count4 += 1;
            }
        }
        int[] counts = {count1, count2, count3, count4};
        List<TrainingByPartForMonth> trainingByPartForMonth = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            trainingByPartForMonth.add(TrainingByPartForMonth
                                               .builder()
                                               .trainingByPart(i)
                                               .trainingTimesByPartForMonth(counts[i - 1])
                                               .build());
        }
        return trainingByPartForMonth;
    }


    public void postTrainingInfo(CreateTrainingRequest request) {
        //TODO: 同じメニューと日付が被っていたらupdateの処理を追加したい
        String[] chest = {"ダンベルフライ", "ベンチプレス", "インクラインベンチプレス", "ケーブルフライ"};
        String[] shoulder = {"ショルダープレス"};
        String[] back = {"ラットプルダウン"};
        int trainingByPart;
        if (Arrays.stream(chest).anyMatch(x -> x.equals(request.getTrainingMenu()))) {
            trainingByPart = 1;
        } else if (Arrays.stream(shoulder).anyMatch(x -> x.equals(request.getTrainingMenu()))) {
            trainingByPart = 2;
        } else if (Arrays.stream(back).anyMatch(x -> x.equals(request.getTrainingMenu()))) {
            trainingByPart = 3;
        } else {
            trainingByPart = 4;
        }
        trainingMapper.createTrainingInfo(Training.builder()
                                                  .userId(request.getId())
                                                  .trainingMenu(request.getTrainingMenu())
                                                  .trainingByPart(trainingByPart)
                                                  .times(request.getTimes())
                                                  .reps(request.getReps())
                                                  .trainingDate(request.getDate())
                                                  .build());
    }
}
