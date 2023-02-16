package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HeightMapper {

    void postHeightInfo(Height height);
}
