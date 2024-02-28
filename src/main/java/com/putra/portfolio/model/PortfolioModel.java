package com.putra.portfolio.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("portfolio")
public class PortfolioModel {
    @Id
    private String id;

    private String name;

    @CreatedDate
    private Instant createdDate;

    private String description;

    private String link;

    private List<byte[]> images;
}
