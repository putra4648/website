package com.putra.portfolio.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.putra.portfolio.dto.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
    public Optional<UserModel> findByUsername(String username);
}
