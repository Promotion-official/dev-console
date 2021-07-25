package com.promotion.devconsole.service;

import com.promotion.devconsole.domain.Permission;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorizeKeyServiceTest {
    private AuthorizeKeyService authorizeKeyService;
    private PasswordEncoder passwordEncoder;
    private LoremIpsum lorem;

    @BeforeEach
    public void init() {
        passwordEncoder = mock(PasswordEncoder.class);
        authorizeKeyService = new AuthorizeKeyService(passwordEncoder);
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
}
