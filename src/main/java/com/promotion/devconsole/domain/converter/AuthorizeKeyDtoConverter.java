package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.Permission;
import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.entity.Api;
import com.promotion.devconsole.entity.AuthorizeKey;
import com.promotion.devconsole.repository.ApiRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizeKeyDtoConverter implements DtoConverter<AuthorizeKey, AuthorizeKeyDto> {
    private final ApiRepository apiRepository;

    @Override
    public AuthorizeKey convertToEntity(AuthorizeKeyDto dto) {
        return AuthorizeKey.builder()
                .authorizeKey(dto.getAuthorizeKey())
                .api(dto.getApi().getName())
                .permission(dto.getPermission().name())
                .build();
    }

    @Override
    public AuthorizeKeyDto convertToDto(AuthorizeKey entity) {
        Api api = apiRepository.getById(entity.getApi());
        ApiDto dto = new ApiDto(api.getName(), api.getUrl());

        String key = entity.getAuthorizeKey();

        Permission permission = Permission.valueOf(entity.getPermission());

        return new AuthorizeKeyDto(key, dto, permission);
    }
}
