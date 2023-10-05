package com.example.restapijfasttext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapijfasttext.model.Classify;
import com.example.restapijfasttext.service.ClassifyService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @PostMapping("/classify")
    public ResponseEntity<Classify> getPrediction(@RequestBody Classify classify) {
        try {
            Classify _classify = classifyService.predictLabel(classify.getText());
            return new ResponseEntity<>(_classify, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
