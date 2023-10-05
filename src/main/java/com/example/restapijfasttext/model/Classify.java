package com.example.restapijfasttext.model;

public class Classify {
    private String text = "";
    private String prediction = "";
    private Double probability = 0.0;

    public Classify() {

    }

    public Classify(String text) {
        this.text = text;
    }

    public Classify(String text, String prediction, Double probability) {
        this.text = text;
        this.prediction = prediction;
        this.probability = probability;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrediction() {
        return this.prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public Double getProbability() {
        return this.probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public void setAll(String text, String prediction, Double probability) {
        this.text = text;
        this.prediction = prediction;
        this.probability = probability;
    }
}
