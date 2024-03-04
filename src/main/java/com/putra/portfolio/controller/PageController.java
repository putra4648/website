package com.putra.portfolio.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.putra.portfolio.service.ProjectService;

@Controller
public class PageController {
    @Autowired
    private ProjectService portfolioService;

    @GetMapping("/")
    public ModelAndView indexPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("index.html");
    }

    @GetMapping("/projects")
    public ModelAndView portfolioPage(ModelMap model) {
        model.put("isActive", true);
        model.put("projects", portfolioService.getList().getBody().getResults());
        return new ModelAndView("projects.html", model);
    }

    @GetMapping("/experience")
    public ModelAndView workPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("experience.html", model);
    }

    @GetMapping("/contact")
    public ModelAndView contactPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("contact.html", model);
    }

    @GetMapping("/download-cv")
    public ResponseEntity<?> downloadCV() {
        try {
            File file = new File("C:\\Users\\muham\\Downloads\\test.pdf");
            byte[] res = FileCopyUtils.copyToByteArray(file);
            return ResponseEntity
                    .ok()

                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new ByteArrayResource(res));
        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", e.getLocalizedMessage());
            return ResponseEntity.internalServerError().body(body);
        }
    }
}
