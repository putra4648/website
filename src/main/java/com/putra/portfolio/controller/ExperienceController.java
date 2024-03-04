package com.putra.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.putra.portfolio.response.AppResponse;

@RestController
@RequestMapping("api/v1")
public class ExperienceController {
    private Map<String, Object> exp = new HashMap<>() {
        {
            put("web", List.of("HTML", "CSS", "Javascript"));
            put("framework", List.of("React.js", "Springboot", "Angular.js"));
            put("database", List.of("Oracle", "MongoDB", "MySQL"));
            put("css", List.of("Tailwind", "Bootstrap", "MUI"));
            put("tool", List.of("VSCode", "Postman", "Git", "VIM"));
        }
    };

    @GetMapping("experience")
    public ResponseEntity<AppResponse<Map<String, Object>>> getExp() {
        AppResponse<Map<String, Object>> body = new AppResponse<>();
        body.setError(false);
        body.setMessage("Success");
        body.setResults(List.of(exp));
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("download-cv")
    public ResponseEntity<?> downloadCV() {
        try {
            File fileCV = ResourceUtils.getFile("classpath:static/cv.pdf");
            byte[] byteArr = Files.readAllBytes(fileCV.toPath());
            return ResponseEntity.ok().body(new ByteArrayResource(byteArr));
        } catch (IOException e) {
            e.printStackTrace();
            Map<String, Object> body = new HashMap<>();
            body.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
