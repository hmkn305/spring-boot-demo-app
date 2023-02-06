package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ItemMapper {

    Item findById(int id);

}
