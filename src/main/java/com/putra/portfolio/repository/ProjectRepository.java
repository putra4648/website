package com.putra.portfolio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.putra.portfolio.model.ProjectModel;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
    List<ProjectModel> findByName(String name);
}
