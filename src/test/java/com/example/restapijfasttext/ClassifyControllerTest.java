package com.example.restapijfasttext;

import com.example.restapijfasttext.controller.ClassifyController;
import com.example.restapijfasttext.model.Classify;
import com.example.restapijfasttext.service.ClassifyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClassifyController.class)
public class ClassifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassifyService classifyService;

    @Test
    public void testConnection() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("Welcome to Tetanggaku NLP Chat Service!")
                ));
    }

    @Test
    public void testPredict() throws Exception {
        Classify classify = new Classify("Ini adalah teks prediksi.");

        // Konversi objek Classify ke JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(classify);

        // Konfigurasi objek palsu ClassifyService
        when(classifyService.predictLabel("Ini adalah teks prediksi."))
                .thenReturn(new Classify("Ini adalah teks prediksi.", "Prediction Label", 0.85));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/predict")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prediction").value("Prediction Label"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.probability").value(0.85));
    }
}
