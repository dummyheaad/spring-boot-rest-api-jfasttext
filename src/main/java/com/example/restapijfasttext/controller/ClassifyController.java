package com.example.restapijfasttext.controller;

import com.example.restapijfasttext.model.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restapijfasttext.service.ClassifyService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClassifyController {

    private final ClassifyService classifyService;

    ClassifyController(@Autowired ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    @GetMapping
    public String testConnection() {
        return "Welcome to Tetanggaku NLP Chat Service!";
    }

    @PostMapping("/predict")
    public ResponseEntity<Classify> getPrediction(@RequestBody Classify c) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            Classify classify = classifyService.predictLabel(c.text());
            return new ResponseEntity<>( classify, headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
