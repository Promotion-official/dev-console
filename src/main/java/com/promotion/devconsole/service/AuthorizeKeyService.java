package com.promotion.devconsole.service;

import com.promotion.devconsole.domain.PermissionEnum;
import com.promotion.devconsole.domain.converter.AuthorizeKeyDtoConverter;
import com.promotion.devconsole.domain.dto.AuthorizeKeyDto;
import com.promotion.devconsole.repository.AuthorizeKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizeKeyService {
    private final AuthorizeKeyRepository authorizeKeyRepository;
    private final AuthorizeKeyDtoConverter authorizeKeyDtoConverter;
    private final PasswordEncoder passwordEncoder;

    public String generateAuthorizeKey(PermissionEnum permission, String key) {
        return passwordEncoder.encode(permission + key);
    }

    public AuthorizeKeyDto getAuthorizeKey(String key) {
        return authorizeKeyDtoConverter.convertToDto(authorizeKeyRepository.getAuthorizeKeyByAuthorizeKey(key));
    }
}
