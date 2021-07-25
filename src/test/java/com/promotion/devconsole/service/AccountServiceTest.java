package com.promotion.devconsole.service;

import com.promotion.devconsole.entity.Developer;
import com.promotion.devconsole.repository.DeveloperRepository;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
    DeveloperRepository developerRepository;
    PasswordEncoder passwordEncoder;
    AccountService accountService;
    LoremIpsum lorem;

    @BeforeEach
    public void init() {
        developerRepository = mock(DeveloperRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        accountService = new AccountService(developerRepository, passwordEncoder);
        lorem = LoremIpsum.getInstance();
    }

    @Test
    public void testLogin() {
        String id = lorem.getWords(1);
        String pw = lorem.getWords(1);
        Developer developer = mock(Developer.class);

        when(developer.getPw()).thenReturn(pw);

        when(developerRepository.existsById(id)).thenReturn(true);
        when(developerRepository.getById(id)).thenReturn(developer);
        when(passwordEncoder.matches(pw, pw)).thenReturn(true);

        boolean isLoginSuccess = accountService.login(id, pw);

        verify(developerRepository).existsById(id);
        verify(developerRepository).getById(id);

        assertTrue(isLoginSuccess);
    }

    @Test
    public void testLoginFailure() {
        String id = lorem.getWords(1);
        String pw = lorem.getWords(1);
        Developer developer = mock(Developer.class);

        when(developer.getPw()).thenReturn(pw);

        when(developerRepository.existsById(id)).thenReturn(false);
        when(developerRepository.getById(id)).thenReturn(developer);
        when(passwordEncoder.matches(pw, pw)).thenReturn(true);

        boolean isLoginSuccess = accountService.login(id, pw);

        verify(developerRepository).existsById(id);
        verify(developerRepository, never()).getById(id);

        assertFalse(isLoginSuccess);
    }

    @Test
    public void testLoginFailure2() {
        String id = lorem.getWords(1);
        String pw = lorem.getWords(1);
        Developer developer = mock(Developer.class);

        when(developer.getPw()).thenReturn(pw);

        when(developerRepository.existsById(id)).thenReturn(true);
        when(developerRepository.getById(id)).thenReturn(developer);
        when(passwordEncoder.matches(pw, pw)).thenReturn(false);

        boolean isLoginSuccess = accountService.login(id, pw);

        verify(developerRepository).existsById(id);
        verify(developerRepository).getById(id);

        assertFalse(isLoginSuccess);
    }
}
