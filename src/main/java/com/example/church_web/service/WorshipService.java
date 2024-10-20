package com.example.church_web.service;

import com.example.church_web.dto.WorshipDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorshipService {
    WorshipDto.CreateResDto create(WorshipDto.CreateReqDto requestDto);
    void update(WorshipDto.UpdateReqDto requestDto);
    void delete(Long id);
    WorshipDto.DetailResDto detail(Long id);
    List<WorshipDto.DetailResDto> list();
}

