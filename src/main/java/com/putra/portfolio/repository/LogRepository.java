package com.putra.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.putra.portfolio.model.LogModel;

public interface LogRepository extends MongoRepository<LogModel, String> {

}
