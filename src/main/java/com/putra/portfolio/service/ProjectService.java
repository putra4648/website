package com.putra.portfolio.service;

import org.springframework.http.ResponseEntity;

import com.putra.portfolio.dto.ProjectDto;
import com.putra.portfolio.request.ProjectRequest;
import com.putra.portfolio.response.AppResponse;

public interface ProjectService {
    public ResponseEntity<AppResponse<String>> upload(ProjectRequest request);

    public ResponseEntity<AppResponse<ProjectDto>> getList();
}
