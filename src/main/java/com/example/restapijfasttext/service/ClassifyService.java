package com.example.restapijfasttext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapijfasttext.model.Classify;
import com.github.jfasttext.JFastText;

@Service
public class ClassifyService {

    private final Classify classify;
    private final JFastText jft;

    // load model
    public ClassifyService(@Autowired Classify classify, @Autowired JFastText jft) {
        this.classify = classify;
        this.jft = jft;
    }

    // predict and return label text
    public Classify predictLabel(String text) {
        JFastText.ProbLabel probLabel = jft.predictProba(text);
        classify.setAll(text, probLabel.label, Math.exp(probLabel.logProb));
        return classify;
    }

    // load model
    public void init() {
        this.jft.loadModel("./src/test/resources/models/model_cooking.bin");
    }
}
