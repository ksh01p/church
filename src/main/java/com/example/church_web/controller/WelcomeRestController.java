package com.example.church_web.controller;

import com.example.church_web.domain.Welcome;
import com.example.church_web.service.WelcomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/welcome")
@RestController
public class WelcomeRestController {

    private final WelcomeService welcomeService;

    public WelcomeRestController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @PostMapping("/create") // Changed to POST for creating entries
    public Map<String, Object> create(@RequestBody Map<String, Object> params) {
        return welcomeService.createWelcome(params);
    }

}
