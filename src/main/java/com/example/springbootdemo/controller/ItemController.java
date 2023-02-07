package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.mapper.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemResponse findById(@PathVariable int id) {
        // DBからidをキーにデータを取得
        Item item = itemMapper.findById(id);

        System.out.println("バックエンドまで届いた");

        // Responseにデータをコピーしてreturn
        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(item, itemResponse);
        return itemResponse;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponse> getItems() {

        List<ItemResponse> itemResponseList = new ArrayList<>();

        List<Item> itemList = itemMapper.findAll();
        itemList.forEach(item -> {
            ItemResponse itemResponse = new ItemResponse();
            BeanUtils.copyProperties(item, itemResponse);
            itemResponseList.add(itemResponse);
        });

        return itemResponseList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ItemResponse doPost(@RequestBody ItemRequest itemRequest) {

        Item item = new Item();
        BeanUtils.copyProperties(itemRequest, item);

        itemMapper.insert(item);

        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(item, itemResponse);

        return itemResponse;
    }
}
