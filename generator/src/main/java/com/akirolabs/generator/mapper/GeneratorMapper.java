package com.akirolabs.generator.mapper;

import com.akirolabs.generator.model.TokenModel;
import com.akirolabs.generator.web.api.model.GenerateTokenRequest;
import com.akirolabs.generator.web.api.model.GenerateTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GeneratorMapper {

    TokenModel toModel(GenerateTokenRequest tokenRequest);

    GenerateTokenResponse toResponse(TokenModel tokenModel);
}
