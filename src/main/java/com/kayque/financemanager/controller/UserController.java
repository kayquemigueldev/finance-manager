package com.kayque.financemanager.controller;

import com.kayque.financemanager.dto.CreateUserRequest;
import com.kayque.financemanager.dto.UserResponse;
import com.kayque.financemanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid CreateUserRequest request) {
        return userService.create(request);
    }

    @GetMapping("/me")
    public UserResponse getAuthenticatedUser(Authentication authentication) {
        return userService.getAuthenticatedUser(authentication.getName());
    }
}