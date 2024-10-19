package com.example.church_web.service.impl;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.church_web.domain.Worship;
import org.springframework.stereotype.Service;
import com.example.church_web.dto.WorshipDto;
import com.example.church_web.service.WorshipService;
import com.example.church_web.repository.WorshipRepository;



@Service
public class WorshipServiceImpl implements WorshipService {

    private final WorshipRepository worshipRepository;


    public WorshipServiceImpl(WorshipRepository worshipRepository) {
        this.worshipRepository = worshipRepository;
    }

    @Override
    public WorshipDto.CreateResDto saveVideoUrl(WorshipDto.CreateReqDto requestDto) {
        Worship worship = requestDto.toEntity();  // DTO -> Entity 변환
        worship.setUploadDate(LocalDateTime.now());  // 업로드 날짜 설정
        Worship savedWorship = worshipRepository.save(worship);  // DB에 저장

        WorshipDto.CreateResDto responseDto = new WorshipDto.CreateResDto();
        responseDto.setId(savedWorship.getId());
        return responseDto;
    }

    @Override
    public void update(WorshipDto.UpdateReqDto requestDto) {
        Worship worship = worshipRepository.findById((requestDto.getId())+"").orElseThrow(() -> new RuntimeException("Worship not found"));
        worship.setTitle(requestDto.getTitle());
        worship.setUrl(requestDto.getUrl());
        worshipRepository.save(worship);
    }

    @Override
    public void delete(Long id) {
        worshipRepository.deleteById(id+"");
    }

    @Override
    public WorshipDto.DetailResDto detail(Long id) {
        Worship worship = worshipRepository.findById(id+"").orElseThrow(() -> new RuntimeException("Worship not found"));
        return new WorshipDto.DetailResDto(worship);
    }

    @Override
    public List<WorshipDto.DetailResDto> getAllVideos() {
        List<Worship> videos = worshipRepository.findAll();
        return videos.stream()
                .map(WorshipDto.DetailResDto::new)
                .collect(Collectors.toList());
    }
}
