package com.example.restapijfasttext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.example.restapijfasttext.model.Classify;

public class ClassifyTest {
    
    @Test
    public void testDefaultConstructor() {
        Classify classify = new Classify();

        assertNull(classify.text());
        assertNull(classify.prediction());
        assertNull(classify.probability());
    }

    @Test
    public void testConstructorWithText() {
        Classify classify = new Classify("lorem ipsum");

        assertEquals("lorem ipsum", classify.text());
        assertNull(classify.prediction());
        assertNull(classify.probability());
    }
}
