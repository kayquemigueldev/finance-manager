package com.kayque.financemanager.controller;

import com.kayque.financemanager.dto.DashboardResponse;
import com.kayque.financemanager.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public DashboardResponse getSummary(Authentication authentication) {
        return service.getSummary(authentication.getName());
    }
}