package com.putra.portfolio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.putra.portfolio.dto.UserModel;
import com.putra.portfolio.repository.UserRepository;
import com.putra.portfolio.request.RegisterRequest;
import com.putra.portfolio.response.AppResponse;
import com.putra.portfolio.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userExist = repository.findByUsername(username);

        if (userExist.isPresent()) {
            UserModel user = userExist.get();
            UserDetails details = User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
            return details;
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    @Override
    public ResponseEntity<AppResponse<String>> registerUser(Optional<RegisterRequest> request) {
        AppResponse<String> response = new AppResponse<>();

        if (!request.isPresent()) {
            response.setError(true);
            response.setMessage("Response cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }

        RegisterRequest body = request.get();
        Optional<UserModel> details = repository.findByUsername(body.getUsername());

        if (!details.isPresent()) {
            UserModel model = new UserModel();

            model.setIsActive(true);
            model.setUsername(body.getUsername());
            model.setPassword(passwordEncoder.encode(body.getPassword()));
            model.setRole("SUPERADMIN");
            repository.save(model);

            response.setError(false);
            response.setMessage("Success created account");
            return ResponseEntity.ok().body(response);
        } else {
            response.setError(true);
            response.setMessage("User already registered");
            return ResponseEntity.ok().body(response);
        }
    }

}
