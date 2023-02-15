package com.example.springbootdemo.controllers.training;

import com.example.springbootdemo.controllers.training.requests.*;
import com.example.springbootdemo.service.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/api/training")
@CrossOrigin
public class trainingOfTheWeekController {

    @Autowired
    TrainingService trainingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingOfTheWeekResponse> getTrainingHistory(@NotNull @RequestParam("id") Integer userId){
        System.out.println(trainingService.getTrainingHistory(userId));
        return trainingService.getTrainingHistory(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void postTrainingInfo(@RequestBody @Validated CreateTrainingRequest request){
        trainingService.postTrainingInfo(request);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class TrainingOfTheWeekResponse {
        private LocalDate trainingDate;
        List<TrainingOfTheWeekDetail> trainingOfTheWeekDetailList;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class TrainingOfTheWeekDetail {
        private int userId;
        private String trainingMenu;
        private int times;
        private int reps;
        private int theTimesGotoGymInTheWeek;
    }
}
