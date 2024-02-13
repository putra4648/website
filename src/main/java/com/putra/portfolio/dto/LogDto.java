package com.putra.portfolio.dto;

import lombok.Data;

@Data
public class LogDto {
    private String type;
    private String httpMethod;
    private String message;
}
