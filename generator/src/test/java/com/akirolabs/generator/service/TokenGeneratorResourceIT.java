package com.akirolabs.generator.service;

import com.akirolabs.generator.mapper.GeneratorMapper;
import com.akirolabs.generator.web.api.model.GenerateTokenRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class TokenGeneratorResourceIT {
    private static final String ENTITY_API_URL = "/api/generate";
    @Autowired
    private GeneratorMapper generatorMapper;

    @Autowired
    private MockMvc restMemberMockMvc;
    private GenerateTokenRequest generateTokenRequest;


    @Test
    void createValidToken() throws Exception {
        generateTokenRequest = new GenerateTokenRequest("1,2,3,4");
        restMemberMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(generateTokenRequest))
            )
            .andExpect(status().isCreated());
    }

    @Test
    void createToken_whenInvalidDigit() throws Exception {
        generateTokenRequest = new GenerateTokenRequest("1,2,3,4,Y");
        restMemberMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsBytes(generateTokenRequest))
            )
            .andExpect(status().isBadRequest());
    }
}
