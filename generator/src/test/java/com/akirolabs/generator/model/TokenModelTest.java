package com.akirolabs.generator.model;

import com.akirolabs.generator.exception.TokenGeneratorException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenModelTest {

    @Test
    void generateTokenWith_removeCommaSeparation_andGenerateToken() {
        //Given
        var digits = "2,4,7,9,0";
        var tokenModel = TokenModel.builder().digits(digits).build();

        //Act
        var modelResult = tokenModel.generateToken();

        //Assert
        Assertions.assertThat(modelResult.getToken()).isNotNull();
    }

    @Test
    void generateTokenWith_givenInvalidStringDigits_throwIllegalException() {
        //Given
        var digits = "2,4,7,9,0,A";
        var tokenModel = TokenModel.builder().digits(digits).build();

        //Act
        assertThrows(TokenGeneratorException.class, tokenModel::generateToken);

    }

    @Test
    void generateTokenWith_givenEmptyStringDigits_throwIllegalException() {
        //Given
        var digits = "";
        var tokenModel = TokenModel.builder().digits(digits).build();

        //Act
        assertThrows(TokenGeneratorException.class, tokenModel::generateToken);

    }
}