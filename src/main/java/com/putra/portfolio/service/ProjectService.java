package com.putra.portfolio.service;

import org.springframework.http.ResponseEntity;

import com.putra.portfolio.dto.ProjectDto;
import com.putra.portfolio.request.PortfolioRequest;
import com.putra.portfolio.response.AppResponse;

public interface ProjectService {
    public ResponseEntity<AppResponse<String>> upload(PortfolioRequest request);

    public ResponseEntity<AppResponse<ProjectDto>> getList();
}
