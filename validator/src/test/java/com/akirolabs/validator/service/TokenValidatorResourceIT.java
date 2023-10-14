package com.akirolabs.validator.service;

import com.akirolabs.validator.TokenValidationApplication;
import com.akirolabs.validator.mapper.ValidatorMapper;
import com.akirolabs.validator.web.api.model.ValidateTokenRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest(classes = { TokenValidationApplication.class})
class TokenValidatorResourceIT {
    private static final String ENTITY_API_URL = "/api/validate";

    @Autowired
    private ValidatorMapper validatorMapper;

    @Autowired
    private MockMvc restMemberMockMvc;

    @Test
    void validateAValidToken() throws Exception {
        var validateTokenRequest = new ValidateTokenRequest();
        validateTokenRequest.setToken("0727-7994-7777-7709");
        restMemberMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(validateTokenRequest))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.valid").value(true))
            .andExpect(jsonPath("$.message").value("Valid token"));
    }

    @Test
    void validate_InvalidToken() throws Exception {
        var validateTokenRequest = new ValidateTokenRequest();
        validateTokenRequest.setToken("1423-3242-3312-2413");
        restMemberMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsBytes(validateTokenRequest))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.valid").value(false))
            .andExpect(jsonPath("$.message").value("Invalid token"));
    }

}
