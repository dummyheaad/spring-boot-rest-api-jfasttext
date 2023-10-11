package com.example.restapijfasttext.controller;

import com.example.restapijfasttext.model.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public HttpStatus testConnection() {

        return HttpStatus.OK;
    }

    @PostMapping("/predict")
    public ResponseEntity<Classify> getPrediction(@RequestBody Classify classify) {
        try {
            Classify _classify = classifyService.predictLabel(classify.text());
            return new ResponseEntity<>(_classify, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
