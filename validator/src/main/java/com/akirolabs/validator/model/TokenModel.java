package com.akirolabs.validator.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
@Slf4j
public class TokenModel {
    private String token;
    private boolean valid;
    private String message;

    public TokenModel validateToken() {
        log.info("token {}: is getting validated", token);
        this.token = this.token.replace("-","");
        log.info("Removed '-' from {}", token);

        int totalDigits = this.token.length();

        int totalSum = 0;
        boolean nextSequence = false;
        for (int i = totalDigits - 1; i >= 0; i--) {
            int d = this.token.charAt(i) - '0';
            if (nextSequence) {
                d = d * 2;
            }
            totalSum += d / 10;
            totalSum += d % 10;

            nextSequence = !nextSequence;
        }
        return validationResult(totalSum % 10 == 0);
    }

    private TokenModel validationResult(boolean valid){
        this.valid = valid;

        if (valid) {
            this.message = "Valid token";
        } else {
            this.message = "Invalid token";
        }
        log.info("token is {} ", this.message);
        return this;
    }
}
