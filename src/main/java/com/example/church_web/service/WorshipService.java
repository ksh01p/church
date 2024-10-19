package com.example.church_web.service;

import com.example.church_web.dto.WorshipDto;
import com.example.church_web.domain.Worship;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorshipService {
    WorshipDto.CreateResDto saveVideoUrl(WorshipDto.CreateReqDto requestDto);
    void update(WorshipDto.UpdateReqDto requestDto);
    void delete(Long id);
    WorshipDto.DetailResDto detail(Long id);
    List<WorshipDto.DetailResDto> getAllVideos();
}

