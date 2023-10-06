package com.example.restapijfasttext.service;

import com.example.restapijfasttext.model.Classify;
import com.github.jfasttext.JFastText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

//@Service
//public class ClassifyService {
//    static Classify classify = new Classify();
//    static JFastText jft = new JFastText();
//
//    // load model
//    public ClassifyService() {
//        jft.loadModel("./src/test/resources/models/model_cooking.bin");
//    }
//
//    // predict and return label text
//    public Classify predictLabel(String text) {
//        JFastText.ProbLabel probLabel = jft.predictProba(text);
//        classify.setAll(text, probLabel.label, Math.exp(probLabel.logProb));
//        return classify;
//    }
//}

@Service
public class ClassifyService {

    private final ApplicationContext context;
    private Classify classify = new Classify();

    @Autowired
    public ClassifyService(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    public Classify predictLabel(String text) {
        JFastText jFastText = context.getBean(JFastText.class);
        JFastText.ProbLabel label = jFastText.predictProba(text);

        classify.setAll(text, label.label, Math.exp(label.logProb));
        return classify;
    }

}
