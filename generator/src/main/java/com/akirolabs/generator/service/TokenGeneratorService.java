package com.akirolabs.generator.service;

import com.akirolabs.generator.mapper.GeneratorMapper;
import com.akirolabs.generator.web.api.TokenGeneratorApiDelegate;
import com.akirolabs.generator.web.api.model.GenerateTokenRequest;
import com.akirolabs.generator.web.api.model.GenerateTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TokenGeneratorService implements TokenGeneratorApiDelegate {

    private final GeneratorMapper generatorMapper;

    @Override
    public ResponseEntity<GenerateTokenResponse> generate(GenerateTokenRequest generateTokenRequest) {
        log.info("Generating token request with {}:", generateTokenRequest);

        var token = generatorMapper.toModel(generateTokenRequest).generateToken();
        return new ResponseEntity<>(generatorMapper.toResponse(token), HttpStatus.CREATED);
    }
}
