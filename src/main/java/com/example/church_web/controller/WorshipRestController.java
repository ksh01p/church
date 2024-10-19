package com.example.church_web.controller;
import com.example.church_web.domain.Worship;
import com.example.church_web.dto.WorshipDto;

import com.example.church_web.service.WorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/worship")
public class WorshipRestController {

    private final WorshipService worshipService;

    @Autowired
    public WorshipRestController(WorshipService worshipService) {
        this.worshipService = worshipService;
    }


    // Create (영상 업로드)
    @PostMapping("")
    public WorshipDto.CreateResDto create(@RequestBody WorshipDto.CreateReqDto param) {
        return worshipService.saveVideoUrl(param);
    }

    // Update (영상 업데이트)
    @PutMapping("")
    public void update(@RequestBody WorshipDto.UpdateReqDto param) {
        worshipService.update(param);
    }

    // Delete (영상 삭제)
    @DeleteMapping("")
    public void delete(@RequestParam Long id) {
        worshipService.delete(id);
    }

    // Get Detail (특정 영상 조회)
    @GetMapping("/detail")
    public WorshipDto.DetailResDto detail(@RequestParam Long id) {
        return worshipService.detail(id);
    }

    // Get List (영상 목록 조회)
    @GetMapping("/list")
    public List<WorshipDto.DetailResDto> list() {
        return worshipService.getAllVideos();
    }

}

