package com.putra.portfolio.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("logs")
public class LogModel {
    @Id
    private String id;

    @CreatedDate
    private Instant time;

    private String url;

    private String type;

    private String httpMethod;

    private String message;

}
