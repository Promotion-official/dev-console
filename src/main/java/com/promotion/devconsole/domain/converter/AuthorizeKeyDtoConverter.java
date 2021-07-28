package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.domain.dto.PermissionDto;
import com.promotion.devconsole.domain.entity.Api;
import com.promotion.devconsole.domain.entity.AuthorizeKey;
import com.promotion.devconsole.domain.entity.Permission;
import com.promotion.devconsole.repository.ApiRepository;
import com.promotion.devconsole.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizeKeyDtoConverter implements DtoConverter<AuthorizeKey, AuthorizeKeyDto> {
    private final ApiRepository apiRepository;
    private final PermissionRepository permissionRepository;
    private final PermissionDtoConverter permissionDtoConverter;

    @Override
    public AuthorizeKey convertToEntity(AuthorizeKeyDto dto) {
        return AuthorizeKey.builder()
                .idx(dto.getIdx())
                .authorizeKey(dto.getAuthorizeKey())
                .api(dto.getApi().getName())
                .permission(dto.getPermission().getId())
                .build();
    }

    @Override
    public AuthorizeKeyDto convertToDto(AuthorizeKey entity) {
        Long idx = entity.getIdx();

        Api api = apiRepository.getById(entity.getApi());
        ApiDto apiDto = new ApiDto(api.getName(), api.getUrl());

        String key = entity.getAuthorizeKey();

        Permission permission = permissionRepository.getById(entity.getPermission());
        PermissionDto permDto = permissionDtoConverter.convertToDto(permission);

        return new AuthorizeKeyDto(idx, key, apiDto, permDto);
    }
}
