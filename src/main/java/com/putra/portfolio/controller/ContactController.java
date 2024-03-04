package com.putra.portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.putra.portfolio.response.AppResponse;

@RestController
@RequestMapping("api/v1")
public class ContactController {
    private Map<String, Object> contacts = new HashMap<>() {
        {
            put("linkedin", "https://www.linkedin.com/in/danar-putra-pradana-8b26a71b1/");
            put("github", "https://github.com/putra4648");
            put("email", "danarputrapradana@yahoo.com");
        }
    };

    @GetMapping("contacts")
    public ResponseEntity<AppResponse<Map<String, Object>>> getContacts() {
        AppResponse<Map<String, Object>> body = new AppResponse<>();
        body.setError(false);
        body.setMessage("Success");
        body.setResults(List.of(contacts));
        return ResponseEntity.ok().body(body);
    }
}
