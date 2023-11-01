package com.example.restapijfasttext.model;

public record Classify(String text, String prediction, Double probability) {
    public Classify() {
        this(null, null, null);
    }

    public Classify(String t) {
        this(t, null, null);
    }
}
