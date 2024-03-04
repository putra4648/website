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
import com.putra.portfolio.request.ForgotPasswordRequest;
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
            response.setMessage("Request body cannot be empty");
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

    @Override
    public ResponseEntity<AppResponse<String>> forgotPassword(Optional<ForgotPasswordRequest> request) {
        AppResponse<String> response = new AppResponse<>();
        if (request.isEmpty()) {
            response.setError(true);
            response.setMessage("Request body cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        ForgotPasswordRequest body = request.get();
        Optional<UserModel> details = repository.findByUsername(body.getUsername());

        if (details.isPresent()) {
            UserModel model = details.get();

            if (!passwordEncoder.matches(body.getOldPassword(), model.getPassword())) {
                response.setError(true);
                response.setMessage("Password is not same");
                return ResponseEntity.ok().body(response);
            }

            if (!body.getNewPassword().equalsIgnoreCase(body.getConfirmationPassword())) {
                response.setError(true);
                response.setMessage("Confirmation password is not same");
                return ResponseEntity.ok().body(response);
            }

            model.setPassword(passwordEncoder.encode(body.getNewPassword()));
            repository.save(model);

            response.setError(false);
            response.setMessage("Success change password");

            return ResponseEntity.ok().body(response);
        } else {
            response.setError(true);
            response.setMessage("User not found");
            return ResponseEntity.ok().body(response);
        }

    }

}
