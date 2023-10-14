package com.akirolabs.validator.mapper;

import com.akirolabs.validator.model.TokenModel;
import com.akirolabs.validator.web.api.model.ValidateTokenRequest;
import com.akirolabs.validator.web.api.model.ValidateTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ValidatorMapper {

    TokenModel toModel(ValidateTokenRequest tokenRequest);

    ValidateTokenResponse toResponse(TokenModel tokenModel);
}
