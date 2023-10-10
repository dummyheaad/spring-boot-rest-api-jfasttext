package com.example.restapijfasttext.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.restapijfasttext.model.Classify;
import com.example.restapijfasttext.service.ClassifyService;
import com.github.jfasttext.JFastText;

@Configuration
public class AppConfig {
    @Bean(initMethod = "init")
    public ClassifyService getClassifyService() {
        return new ClassifyService(getClassify(), getJFastText());
    }

    @Bean
    public Classify getClassify() {
        return new Classify();
    }

    @Bean
    public JFastText getJFastText() {
        return new JFastText();
    }
}
