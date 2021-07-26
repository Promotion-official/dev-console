package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.entity.Api;

public class ApiDtoConverter implements DtoConverter<Api, ApiDto> {
    @Override
    public Api convertToEntity(ApiDto dto) {
        return Api.builder()
                .name(dto.getName())
                .url(dto.getUrl())
                .build();
    }

    @Override
    public ApiDto convertToDto(Api entity) {
        return new ApiDto(entity.getName(), entity.getUrl());
    }
}
