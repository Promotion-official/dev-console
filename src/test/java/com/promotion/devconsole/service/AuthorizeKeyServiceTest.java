package com.promotion.devconsole.service;

import com.promotion.devconsole.domain.Permission;
import com.promotion.devconsole.domain.converter.AuthorizeKeyDtoConverter;
import com.promotion.devconsole.domain.dto.ApiDto;
import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.entity.Api;
import com.promotion.devconsole.repository.ApiRepository;
import com.promotion.devconsole.repository.AuthorizeKeyRepository;
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
    private PasswordEncoder passwordEncoder;

    private AuthorizeKeyDtoConverter authorizeKeyDtoConverter;

    private AuthorizeKeyService authorizeKeyService;

    private LoremIpsum lorem;

    @BeforeEach
    public void init() {
        authorizeKeyRepository = mock(AuthorizeKeyRepository.class);
        apiRepository = mock(ApiRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);

        authorizeKeyDtoConverter = new AuthorizeKeyDtoConverter(apiRepository);

        authorizeKeyService = new AuthorizeKeyService(authorizeKeyRepository, authorizeKeyDtoConverter, passwordEncoder);

        lorem = LoremIpsum.getInstance();
    }

    @Test
    public void testGenerateAuthorizeKey() {
        int randomPermIdx = new Random().nextInt(Permission.values().length);
        Permission permission = Permission.values()[randomPermIdx];

        String key = lorem.getWords(1);
        String encodedKey = key + lorem.getWords(1) + permission;

        when(passwordEncoder.encode(permission + key)).thenReturn(encodedKey);

        String generatedKey = authorizeKeyService.generateAuthorizeKey(permission, key);

        assertEquals(encodedKey, generatedKey);
    }

    @Test
    public void testGetAuthorizeKey() {
        String key = lorem.getWords(1);
        int randomPermissionIdx = new Random().nextInt(Permission.values().length);

        ApiDto apiDto = new ApiDto(lorem.getWords(1), lorem.getUrl());

        Permission randomPermission = Permission.values()[randomPermissionIdx];

        when(apiRepository.getById(apiDto.getName()))
                //TODO 지인호 | ApiDtoConverter 만들어서 수정 | 2021.07.26
                .thenReturn(new Api(apiDto.getName(), apiDto.getUrl()));

        AuthorizeKeyDto expectedResult = new AuthorizeKeyDto(key, apiDto, randomPermission);

        when(authorizeKeyRepository.getById(key))
                .thenReturn(authorizeKeyDtoConverter.convertToEntity(expectedResult));

        AuthorizeKeyDto authorizeKeyDto = authorizeKeyService.getAuthorizeKey(key);

        assertEquals(authorizeKeyDto, expectedResult);
    }
}
