package com.putra.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.putra.portfolio.request.PortfolioRequest;
import com.putra.portfolio.response.AppResponse;
import com.putra.portfolio.service.ProjectService;

@RestController
@RequestMapping("api/v1")
public class PortfolioController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "portfolio", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<AppResponse<String>> uploadPortfolio(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam("images") List<MultipartFile> images) {
        PortfolioRequest body = new PortfolioRequest();
        body.setName(name);
        body.setDescription(description);
        body.setImages(images);
        return projectService.upload(body);
    }

}
