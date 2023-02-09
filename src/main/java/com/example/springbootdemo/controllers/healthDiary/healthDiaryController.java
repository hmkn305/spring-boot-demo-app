package com.example.springbootdemo.controllers.healthDiary;

import org.jetbrains.annotations.*;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void getHealthDiary(@NotNull @RequestParam("id") Integer id,
                               @Validated @RequestParam(name = "date", required = false) @DateTimeFormat(pattern = ISO_LOCAL_DATE_PATTERN) LocalDate startDate){

    }
}
