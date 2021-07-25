package com.promotion.devconsole.service;


import com.promotion.devconsole.entity.Developer;
import com.promotion.devconsole.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AccountService {
    private final DeveloperRepository developerRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean login(String id, String pw) {
        if(!developerRepository.existsById(id))
            return false;

        Developer developer = developerRepository.getById(id);
        return passwordEncoder.matches(pw, developer.getPw());
    }
}
