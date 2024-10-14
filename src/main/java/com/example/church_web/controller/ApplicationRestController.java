package com.example.church_web.controller;

import com.example.church_web.domain.Application;
import com.example.church_web.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/application")
@RestController
public class ApplicationRestController {

    private final ApplicationService applicationService;

    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService =  applicationService;
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String, Object> params) {
        return applicationService.createApplication(params);
    }


}


