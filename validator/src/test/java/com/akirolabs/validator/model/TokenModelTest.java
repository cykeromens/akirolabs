package com.akirolabs.validator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TokenModelTest {


    @Test
    void validateInvalidToken(){
        var tokenModel = TokenModel.builder().token("1423-3242-3312-2413").build();

        var result = tokenModel.validateToken();

        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getMessage()).isEqualTo("Invalid token");
    }

    @Test
    void validateValidToken(){
        var tokenModel = TokenModel.builder().token("0727-7994-7777-7709").build();

        var result = tokenModel.validateToken();

        Assertions.assertThat(result.isValid()).isTrue();
        Assertions.assertThat(result.getMessage()).isEqualTo("Valid token");
    }
}