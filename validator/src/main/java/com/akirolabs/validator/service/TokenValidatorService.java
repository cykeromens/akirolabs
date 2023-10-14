package com.akirolabs.validator.service;

import com.akirolabs.validator.mapper.ValidatorMapper;
import com.akirolabs.validator.web.api.TokenValidatorApiDelegate;
import com.akirolabs.validator.web.api.model.ValidateTokenRequest;
import com.akirolabs.validator.web.api.model.ValidateTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TokenValidatorService implements TokenValidatorApiDelegate {

    private final ValidatorMapper validatorMapper;

    @Override
    public ResponseEntity<ValidateTokenResponse> validate(ValidateTokenRequest validateTokenRequest) {
        log.info("Validating request {}:", validateTokenRequest);

        var tokenModel = validatorMapper.toModel(validateTokenRequest).validateToken();
        return new ResponseEntity<>(validatorMapper.toResponse(tokenModel), HttpStatus.OK);
    }
}
