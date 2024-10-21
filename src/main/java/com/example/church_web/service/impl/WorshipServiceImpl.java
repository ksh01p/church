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
    public WorshipDto.CreateResDto create(WorshipDto.CreateReqDto requestDto) {
        System.out.println(requestDto.getVid() + "!!!!!!");
        Worship worship = requestDto.toEntity();

        System.out.println(worship.getVId() + "!!!!!!");

        worship.setUploadDate(LocalDateTime.now());
        worship = worshipRepository.save(worship);
        WorshipDto.CreateResDto responseDto = new WorshipDto.CreateResDto();
        responseDto.setId(worship.getId());
        return responseDto;
    }

    @Override
    public void update(WorshipDto.UpdateReqDto requestDto) {
        Worship worship = worshipRepository.findById((requestDto.getId()+""))
                .orElseThrow(() -> new RuntimeException("Worship not found"));

        worship.setTitle(requestDto.getTitle());
        worship.setVId(requestDto.getVId());

        worshipRepository.save(worship);
    }

    @Override
    public void delete(Long id) {
        worshipRepository.deleteById(id+"");
    }

    @Override
    public WorshipDto.DetailResDto detail(Long id) {
        Worship worship = worshipRepository.findById(id+"")
                .orElseThrow(() -> new RuntimeException("Worship not found"));

        WorshipDto.DetailResDto responseDto = new WorshipDto.DetailResDto();
        responseDto.setId(worship.getId());
        responseDto.setTitle(worship.getTitle());
        responseDto.setVId(worship.getVId());
        return responseDto;
    }

    @Override
    public List<WorshipDto.DetailResDto> list() {
        return worshipRepository.findAll().stream()
                .map(worship -> {
                    WorshipDto.DetailResDto dto = new WorshipDto.DetailResDto();
                    dto.setId(worship.getId());
                    dto.setTitle(worship.getTitle());
                    dto.setVId(worship.getVId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}