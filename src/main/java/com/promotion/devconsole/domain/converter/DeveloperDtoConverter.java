package com.promotion.devconsole.domain.converter;

import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.domain.dto.DeveloperDto;
import com.promotion.devconsole.domain.entity.AuthorizeKey;
import com.promotion.devconsole.domain.entity.Developer;
import com.promotion.devconsole.repository.AuthorizeKeyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeveloperDtoConverter implements DtoConverter<Developer, DeveloperDto>{
    private final AuthorizeKeyDtoConverter authorizeKeyDtoConverter;
    private final AuthorizeKeyRepository authorizeKeyRepository;

    @Override
    public Developer convertToEntity(DeveloperDto dto) {
        return Developer.builder()
                .id(dto.getId())
                .pw(dto.getPw())
                .authToken(dto.getAuthToken())
                .authorizeKey(dto.getAuthorizeKey().getAuthorizeKey())
                .build();
    }

    @Override
    public DeveloperDto convertToDto(Developer entity) {
        AuthorizeKey key = authorizeKeyRepository.getAuthorizeKeyByAuthorizeKey(entity.getAuthorizeKey());
        AuthorizeKeyDto keyDto = authorizeKeyDtoConverter.convertToDto(key);
        return new DeveloperDto(
                entity.getId(),
                entity.getPw(),
                entity.getAuthToken(),
                keyDto
                );
    }
}
