package com.putra.portfolio.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.putra.portfolio.request.RegisterRequest;
import com.putra.portfolio.response.AppResponse;

public interface UserService extends UserDetailsService {

    ResponseEntity<AppResponse<String>> registerUser(Optional<RegisterRequest> body);

}
