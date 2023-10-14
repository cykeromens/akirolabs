package com.akirolabs.generator.model;

import com.akirolabs.generator.exception.TokenGeneratorException;
import lombok.Builder;
import lombok.Data;

import java.security.SecureRandom;

@Builder
@Data
public class TokenModel {
    private final String digits;
    private String token;
    private String validDigit;

    public TokenModel generateToken(){
        enrichModel();
        validateDigits();

        return generateNewToken();
    }

    private void enrichModel( ) {
        validDigit = (this.digits.replace(",",""));
    }

    private void validateDigits() {
        try{
            Integer.parseInt(this.validDigit);
        }catch (Exception exception){
            throw new TokenGeneratorException(exception);
        }
    }

    private TokenModel generateNewToken() {
        var tokenBuilderItem = new StringBuilder();
        var tokenBuilder = new StringBuilder();
        var validDigit = this.getValidDigit();

        var counter = 0;
        for (int i = 0; i < 20; i++) {
            if(counter < 4) {tokenBuilderItem.append(validDigit.charAt(new SecureRandom().nextInt(validDigit.length())));
                counter++;
            }else {
                counter = 0;
                tokenBuilder.append(tokenBuilderItem);
                tokenBuilderItem = new StringBuilder();
                if(i+1 != 20){
                    tokenBuilder.append('-');
                }
            }
        }
        this.token = new String(tokenBuilder);
        return this;
    }
}
