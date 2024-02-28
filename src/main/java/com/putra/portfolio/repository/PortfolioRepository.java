package com.putra.portfolio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.putra.portfolio.model.PortfolioModel;

public interface PortfolioRepository extends MongoRepository<PortfolioModel, String> {
    List<PortfolioModel> findByName(String name);
}
