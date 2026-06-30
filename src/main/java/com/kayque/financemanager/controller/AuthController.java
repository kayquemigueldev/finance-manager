package com.kayque.financemanager.controller;

import com.kayque.financemanager.dto.LoginRequest;
import com.kayque.financemanager.dto.LoginResponse;
import com.kayque.financemanager.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }
}