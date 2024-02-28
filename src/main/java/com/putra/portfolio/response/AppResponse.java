package com.putra.portfolio.response;

import java.util.List;

import lombok.Data;

@Data
public class AppResponse<T> {
    private boolean error;
    private String message;
    private List<T> results;
}
