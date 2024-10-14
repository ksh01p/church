package com.example.church_web.service.impl;

import com.example.church_web.domain.Welcome;
import com.example.church_web.repository.WelcomeRepository;
import com.example.church_web.service.WelcomeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    private final WelcomeRepository welcomeRepository;
    public WelcomeServiceImpl(
            WelcomeRepository welcomeRepository
    ) {
        this.welcomeRepository = welcomeRepository;
    }

    @Override
    public Map<String, Object> createWelcome(Map<String, Object> params) {
        System.out.println("createWelcome");
        Welcome welcome = new Welcome();
        welcome.setId(Integer.parseInt(params.get("id") + ""));
        welcome.setTitle(params.get("title").toString());
        welcome.setContent(params.get("content").toString());
        welcome.setAuthor(params.get("author").toString());
        welcomeRepository.save(welcome);
        return null;
    }
    @Override
    public Map<String, Object> updateWelcome(Map<String, Object> params) {
        System.out.println("updateWelcome");
        Welcome welcome = welcomeRepository.findById(params.get("id") + "").orElseThrow(() -> new RuntimeException(""));

        welcome.setTitle(params.get("title").toString());
        welcome.setContent(params.get("content").toString());
        welcome.setAuthor(params.get("author").toString());
        welcomeRepository.save(welcome);
        return null;
    }
    @Override
    public List<Welcome> listWelcome() {
        return welcomeRepository.findAll();
    }
    @Override
    public Welcome detailWelcome(Integer id) {
        return welcomeRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> deleteWelcome(Integer id) {
        Welcome welcome = welcomeRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
        welcomeRepository.delete(welcome);
        return null;
    }
}