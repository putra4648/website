package com.putra.portfolio.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProjectDto {
    private String id;
    private String name;
    private String description;
    private String link;
    private List<String> images;
    private List<String> tags;
}
