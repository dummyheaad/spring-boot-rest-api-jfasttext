package com.example.restapijfasttext.service;

import com.example.restapijfasttext.model.Classify;
import com.github.jfasttext.JFastText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassifyService {

    private static ClassifyService instance;
    private final JFastText jFastText;

    private ClassifyService(@Autowired JFastText jFastText) {
        this.jFastText = jFastText;
    }

    public static ClassifyService getInstance(@Autowired JFastText jFastText) {

        synchronized (ClassifyService.class) {
            if (instance == null) {
                instance = new ClassifyService(jFastText);
            }
        }

        return instance;
    }

    public Classify predictLabel(String text) {
        JFastText.ProbLabel label = jFastText.predictProba(text);
        Classify classify = new Classify(text, label.label, Math.exp(label.logProb));
        return classify;
    }

    /*
     @Autowired
    private JFastText jFastText;

    public Classify predictLabel(String text) {
        JFastText.ProbLabel label = jFastText.predictProba(text);
        Classify classify = new Classify(text, label.label, Math.exp(label.logProb));
        return classify;
    }
     */

}
