package com.example.restapijfasttext.service;

import org.springframework.stereotype.Service;

import com.example.restapijfasttext.model.Classify;
import com.github.jfasttext.JFastText;

@Service
public class ClassifyService {
    static Classify classify = new Classify();
    static JFastText jft = new JFastText();

    // load model
    public ClassifyService() {
        jft.loadModel("./src/test/resources/models/model_cooking.bin");
    }

    // predict and return label text
    public Classify predictLabel(String text) {
        JFastText.ProbLabel probLabel = jft.predictProba(text);
        classify.setAll(text, probLabel.label, Math.exp(probLabel.logProb));
        return classify;
    }
}
