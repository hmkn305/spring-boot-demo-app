package com.example.springbootdemo.controllers.healthDiary;

import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.service.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

import static com.example.springbootdemo.constants.PatternConstants.ISO_LOCAL_DATE_PATTERN;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin
public class healthDiaryController {

    @Autowired
    HealthDiaryService healthDiaryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HealthDiaryResponse getHealthDiary(@NotNull @RequestParam("id") Integer userId,
                                              @Validated @NotNull @RequestParam(name = "date", required = false) @DateTimeFormat(pattern = ISO_LOCAL_DATE_PATTERN) LocalDate date){
        HealthDiary healthDiary = healthDiaryService.getHealthDiary(userId, date);
        HealthDiaryResponse healthDiaryResponse = new HealthDiaryResponse();
        BeanUtils.copyProperties(healthDiary, healthDiaryResponse);
        return healthDiaryResponse;
    }

}