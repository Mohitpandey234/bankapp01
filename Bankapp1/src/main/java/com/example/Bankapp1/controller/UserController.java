package com.example.Bankapp1.controller;


import com.example.Bankapp1.dto.BankResponse;
import com.example.Bankapp1.dto.UserRequest;
import com.example.Bankapp1.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public BankResponse createAccount(@RequestBody  UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }
}
