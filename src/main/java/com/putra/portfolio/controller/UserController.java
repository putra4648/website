package com.putra.portfolio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.putra.portfolio.request.ForgotPasswordRequest;
import com.putra.portfolio.request.RegisterRequest;
import com.putra.portfolio.response.AppResponse;
import com.putra.portfolio.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<AppResponse<String>> registerUser(@RequestBody Optional<RegisterRequest> body) {
        return userService.registerUser(body);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<AppResponse<String>> forgotPassword(@RequestBody Optional<ForgotPasswordRequest> body) {
        return userService.forgotPassword(body);
    }

}
