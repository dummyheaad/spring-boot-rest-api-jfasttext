package com.example.restapijfasttext;

import com.example.restapijfasttext.config.FastTextConfiguration;
import com.github.jfasttext.JFastText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JFastTextBeanTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FastTextConfiguration.class);
    }

    @Test
    void testBeanInitialization() {
        JFastText jft1 = context.getBean("fastTextInit", JFastText.class);
        JFastText jft2 = context.getBean("fastTextInit", JFastText.class);

        Assertions.assertSame(jft1, jft2);
    }
}
