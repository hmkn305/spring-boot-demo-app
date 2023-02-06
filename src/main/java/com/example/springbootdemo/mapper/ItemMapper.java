package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface ItemMapper {

    Item findById(int id);

    List<Item> findAll();

    int insert(@Param("item") Item item);

}
