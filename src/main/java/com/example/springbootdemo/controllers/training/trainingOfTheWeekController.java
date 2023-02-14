package com.example.springbootdemo.controllers.training;

import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.service.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/training")
@CrossOrigin
public class trainingOfTheWeekController {

    @Autowired
    TrainingService trainingService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingOfTheWeekResponse> getTrainingHistory(@NotNull @PathVariable("id") Integer userId){
        System.out.println(userId);
        return trainingService.getTrainingHistory(userId);
    }
}
