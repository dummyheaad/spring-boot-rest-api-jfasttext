package com.example.restapijfasttext.service;

import com.example.restapijfasttext.model.Classify;
import com.github.jfasttext.JFastText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClassifyService {

    @Autowired
    private JFastText jFastText;

    public Classify predictLabel(String text) {
        JFastText.ProbLabel jftLabel = jFastText.predictProba(text);
        Classify classify;
        if (jftLabel != null) {
            String label = switch (jftLabel.label) {
                case "__label__none" -> "none";
                case "__label__harsh" -> "harsh";
                case "__label__sexual" -> "sexual";
                case "__label__fraud" -> "fraud";
                default -> null;
            };
            classify = new Classify(text, label, Math.exp(jftLabel.logProb));
        } else {
            classify = new Classify("Text label is null", "null", -1.0);
        }
        log.info(classify.text());
        return classify;
    }

}
