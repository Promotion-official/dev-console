package com.promotion.devconsole.service;

import com.promotion.devconsole.domain.PermissionEnum;
import com.promotion.devconsole.domain.converter.ApiDtoConverter;
import com.promotion.devconsole.domain.converter.AuthorizeKeyDtoConverter;
import com.promotion.devconsole.domain.converter.PermissionDtoConverter;
import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.domain.dto.PermissionDto;
import com.promotion.devconsole.domain.entity.Permission;
import com.promotion.devconsole.repository.ApiRepository;
import com.promotion.devconsole.repository.AuthorizeKeyRepository;
import com.promotion.devconsole.repository.PermissionRepository;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorizeKeyServiceTest {
    private AuthorizeKeyRepository authorizeKeyRepository;
    private ApiRepository apiRepository;
    private PermissionRepository permissionRepository;

    private PasswordEncoder passwordEncoder;

    private PermissionDtoConverter permissionDtoConverter;
    private AuthorizeKeyDtoConverter authorizeKeyDtoConverter;
    private ApiDtoConverter apiDtoConverter;

    private AuthorizeKeyService authorizeKeyService;

    private LoremIpsum lorem;

    @BeforeEach
    public void init() {
        authorizeKeyRepository = mock(AuthorizeKeyRepository.class);
        apiRepository = mock(ApiRepository.class);
        permissionRepository = mock(PermissionRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);

        permissionDtoConverter = new PermissionDtoConverter();
        authorizeKeyDtoConverter = new AuthorizeKeyDtoConverter(apiRepository, permissionRepository, permissionDtoConverter);
        apiDtoConverter = new ApiDtoConverter();

        authorizeKeyService = new AuthorizeKeyService(
                authorizeKeyRepository,
                authorizeKeyDtoConverter,
                passwordEncoder);

        lorem = LoremIpsum.getInstance();
    }

    @Test
    public void testGenerateAuthorizeKey() {
        int randomPermIdx = new Random().nextInt(PermissionEnum.values().length);
        PermissionEnum permission = PermissionEnum.values()[randomPermIdx];

        String key = lorem.getWords(1);
        String encodedKey = key + lorem.getWords(1) + permission;

        when(passwordEncoder.encode(permission + key)).thenReturn(encodedKey);

        String generatedKey = authorizeKeyService.generateAuthorizeKey(permission, key);

        assertEquals(encodedKey, generatedKey);
    }

    @Test
    public void testGetAuthorizeKey() {
        Long idx = new Random().nextLong();

        String key = lorem.getWords(1);
        int randomPermissionIdx = new Random().nextInt(PermissionEnum.values().length);

        ApiDto apiDto = new ApiDto(lorem.getWords(1), lorem.getUrl());

        PermissionEnum randomPermission = PermissionEnum.values()[randomPermissionIdx];
        PermissionDto permDto = new PermissionDto(randomPermission.name(), randomPermission.getRequestLimit());

        when(apiRepository.getById(apiDto.getName()))
                .thenReturn(apiDtoConverter.convertToEntity(apiDto));

        AuthorizeKeyDto expectedResult = new AuthorizeKeyDto(idx, key, apiDto, permDto);

        when(authorizeKeyRepository.getAuthorizeKeyByAuthorizeKey(key))
                .thenReturn(authorizeKeyDtoConverter.convertToEntity(expectedResult));

        when(permissionRepository.getById(permDto.getId()))
                .thenReturn(new Permission(permDto.getId(), permDto.getRequestLimitPermission()));

        AuthorizeKeyDto authorizeKeyDto = authorizeKeyService.getAuthorizeKey(key);

        assertEquals(authorizeKeyDto, expectedResult);
    }
}
