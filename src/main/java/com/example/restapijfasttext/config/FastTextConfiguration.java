package com.example.restapijfasttext.config;

import com.github.jfasttext.JFastText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan
@Slf4j
public class FastTextConfiguration {

    @Bean
    public JFastText fastTextInit() {
        try {
            log.info("Fast Text model successfully loaded");

            String modelPath = "./src/test/resources/models/model_cooking.bin";

            JFastText jFastText = new JFastText();
            jFastText.loadModel(modelPath);

            return jFastText;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize jFastText", e);
        }
    }
}
