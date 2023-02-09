package com.example.springbootdemo.controllers.accounts;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.entity.*;
import com.example.springbootdemo.service.*;
import org.jetbrains.annotations.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@NotNull @RequestParam("email") String mailAddress,
                                @NotNull @RequestParam("password") String password){
        User user = userService.getUser(mailAddress, password);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        System.out.println("バックエンド");
        return userResponse;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public void postUser(@RequestBody @Validated CreateAccountRequest request) {
        userService.postUser(request);
    }
}
