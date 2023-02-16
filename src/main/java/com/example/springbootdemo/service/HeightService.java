package com.example.springbootdemo.service;


import com.example.springbootdemo.controllers.height.requests.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class HeightService {

    @Autowired
    HeightMapper heightMapper;

    public void postHeightInfo(CreateHeightRequest request){
        heightMapper.postHeightInfo(Height.builder()
                                            .userId(request.getId())
                                            .height(request.getHeight())
                                            .build());
    }
}
