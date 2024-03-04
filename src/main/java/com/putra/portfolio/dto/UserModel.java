package com.putra.portfolio.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("users")
public class UserModel {
    @Id
    private String uid;

    private String username;

    private String password;

    private Boolean isActive;

    private String role;
}
