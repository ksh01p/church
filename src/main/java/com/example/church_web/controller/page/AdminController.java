package com.example.church_web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminHome() {
        return "admin/home"; // admin/index.html 파일이 있어야 합니다.
    }

    // 환영합니다 관리 페이지 매핑
    @GetMapping("/welcome/introduce")
    public String manageIntroduce() {
        return "admin/welcome/introduce";
    }

    @GetMapping("/welcome/fam_signup")
    public String manageFamSignup() {
        return "admin/welcome/fam_signup";
    }

    // 소개합니다 관리 페이지 매핑
    @GetMapping("/introduction/pastor")
    public String managePastor() {
        return "admin/introduction/pastor";
    }

    @GetMapping("/introduction/church")
    public String manageChurch() {
        return "admin/introduction/church";
    }

    // 예배합니다 관리 페이지 매핑
    @GetMapping("/worship/videos")
    public String manageVideos() {
        return "admin/worship/videos";
    }

    @GetMapping("/worship/sunday")
    public String manageSunday() {
        return "admin/worship/sunday";
    }

    // 양육 신청 관리 페이지 매핑
    @GetMapping("/application/apply")
    public String manageApplication() {
        return "admin/application/apply";
    }

    // 선교 상황 관리 페이지 매핑
    @GetMapping("/mission/country")
    public String manageMissionCountry() {
        return "admin/mission/country";
    }
}
