package com.example.springbootdemo.controllers.accounts;

import com.example.springbootdemo.controllers.accounts.requests.*;
import com.example.springbootdemo.dto.*;
import com.example.springbootdemo.service.*;
import org.jetbrains.annotations.*;
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
        return userService.getUser(mailAddress, password);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse postUser(@RequestBody @Validated CreateAccountRequest request) {
        return userService.postUser(request);
    }
}
