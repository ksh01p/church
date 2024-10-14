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

    @GetMapping("/list")
    public List<Welcome> list() {
        return welcomeService.listWelcome(); // Correctly calling the service method
    }

    @GetMapping("/detail") // This should return details for a specific ID
    public Welcome detail(@RequestParam Integer id) {
        return welcomeService.detailWelcome(id);
    }

    @PostMapping("/update") // Changed to POST for updating entries
    public Map<String, Object> update(@RequestBody Map<String, Object> params) {
        return welcomeService.updateWelcome(params);
    }

    @DeleteMapping("/delete") // Changed to DELETE for removing entries
    public Map<String, Object> delete(@RequestParam Integer id) {
        return welcomeService.deleteWelcome(id);
    }
}
