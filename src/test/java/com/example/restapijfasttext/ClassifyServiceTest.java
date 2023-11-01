package com.example.restapijfasttext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restapijfasttext.model.Classify;
import com.example.restapijfasttext.service.ClassifyService;

@SpringBootTest
public class ClassifyServiceTest {
    @Autowired
    private ClassifyService classifyService;
    
    @Test
    public void testPredictLabelNull() {
        Classify expected = new Classify("Text label is null", "null", -1.0);
        Classify actual = classifyService.predictLabel("lorem");
        assertEquals(expected, actual);
    }

    @Test
    public void testPredictLabelNonNull() {
        assertNotNull(classifyService.predictLabel("anjing").text());
        assertNotNull(classifyService.predictLabel("anjing").prediction());
        assertNotNull(classifyService.predictLabel("anjing").probability());
    }
}
