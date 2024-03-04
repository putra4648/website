package com.putra.portfolio.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PortfolioRequest {
    private String name;
    private String description;
    private List<String> tags;
    private List<MultipartFile> images;
}
