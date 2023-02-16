package com.example.springbootdemo.controllers.height;


import com.example.springbootdemo.controllers.height.requests.*;
import com.example.springbootdemo.service.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/height")
@CrossOrigin
public class RegisterHeightController {

    @Autowired
    HeightService heightService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public int postHeightInfo(@RequestBody @Validated CreateHeightRequest request){
        System.out.println(request);
        heightService.postHeightInfo(request);
        return 1;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public double[] getBMIForThreeMonths(@NotNull @RequestParam("id") Integer userId){
        return heightService.getBMIForThreeMonths(userId);
    }
}
