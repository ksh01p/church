package com.example.church_web.controller.page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class AdminController {
    //    @GetMapping({"","/"}) //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String empty(){
//        return "redirect:/index";
//    }
    @GetMapping({"/admin"}) //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String admin(){
        return "admin";
    }
}

/*
@GetMapping("/{page"}")
public String page(@PathVariable String page){return "welcome/"+page;}

--> path variabl e을 선언해서 url 에 있는 값을 변수로 받아 올 수 있는 기능 !
*/

