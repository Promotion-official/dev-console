package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.domain.entity.Api;

public class ApiDtoConverter implements DtoConverter<Api, ApiDto> {
    @Override
    public Api toEntity(ApiDto dto) {
        return Api.builder()
                .name(dto.getName())
                .url(dto.getUrl())
                .build();
    }

    @Override
    public ApiDto toDto(Api entity) {
        return new ApiDto(entity.getName(), entity.getUrl());
    }
}
