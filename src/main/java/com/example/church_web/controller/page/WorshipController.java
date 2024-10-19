package com.example.church_web.controller.page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/worship")
@Controller

public class WorshipController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "worship/" + page;
    }

    //PathVariable을 여러개 쓸수 있음.. 대신 /가 있어야함!
    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "worship/" + page;
    }
}
