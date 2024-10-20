package com.example.church_web.controller;
import com.example.church_web.domain.Worship;
import com.example.church_web.dto.WorshipDto;

import com.example.church_web.service.WorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/worship")
@RestController
public class WorshipRestController {

    private final WorshipService worshipService;

    public WorshipRestController(WorshipService worshipService) {
        this.worshipService = worshipService;
    }

    @PostMapping("")
    public WorshipDto.CreateResDto create(@RequestBody WorshipDto.CreateReqDto requestDto) {
        // 영상 업로드 요청 처리
        return worshipService.create(requestDto);
    }

    @PutMapping("")
    public void update(@RequestBody WorshipDto.UpdateReqDto requestDto) {
        // 영상 업데이트 요청 처리
        worshipService.update(requestDto);
    }

    @DeleteMapping("")
    public void delete(@RequestBody WorshipDto.UpdateReqDto requestDto) {
        // 영상 삭제 요청 처리
        worshipService.delete(requestDto.getId());
    }

    @GetMapping("/detail")
    public WorshipDto.DetailResDto detail(@RequestParam Long id) {
        // 영상 상세 정보 요청 처리
        return worshipService.detail(id);
    }

    @GetMapping("/list")
    public List<WorshipDto.DetailResDto> list() {
        // 모든 영상 리스트 요청 처리
        return worshipService.list();
    }
}