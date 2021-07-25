package com.promotion.devconsole.service;

import com.promotion.devconsole.domain.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizeKeyService {
    private final PasswordEncoder passwordEncoder;

    public String generateAuthorizeKey(Permission permission, String key) {
        return passwordEncoder.encode(permission + key);
    }
}
