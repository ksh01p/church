package com.example.church_web.service;
import com.example.church_web.domain.Welcome;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface WelcomeService {
    Map<String, Object> createWelcome(Map<String, Object> params);
    Map<String, Object> updateWelcome(Map<String, Object> params);
    Map<String, Object> deleteWelcome(Integer id);
    List<Welcome> listWelcome();
    Welcome detailWelcome(Integer id);
}