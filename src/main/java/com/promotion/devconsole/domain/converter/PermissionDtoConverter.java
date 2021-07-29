package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.PermissionDto;
import com.promotion.devconsole.domain.entity.Permission;

public class PermissionDtoConverter implements DtoConverter<Permission, PermissionDto> {
    @Override
    public Permission toEntity(PermissionDto dto) {
        return Permission.builder()
                .id(dto.getId())
                .requestLimitPermission(dto.getRequestLimitPermission())
                .build();
    }

    @Override
    public PermissionDto toDto(Permission entity) {
        return new PermissionDto(entity.getId(), entity.getRequestLimitPermission());
    }
}
