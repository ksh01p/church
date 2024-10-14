package com.example.church_web.service;
import com.example.church_web.domain.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ApplicationService {
    Map<String, Object> createApplication(Map<String, Object> params);

}