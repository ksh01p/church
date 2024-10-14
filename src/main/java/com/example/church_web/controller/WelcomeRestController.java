package com.example.church_web.controller;
import com.example.church_web.domain.Welcome;
import com.example.church_web.service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RequestMapping("/api/welcome")
@RestController
public class WelcomeRestController {

    private final WelcomeService welcomeService;
    public WelcomeRestController(
            WelcomeService welcomeService
    ) {
        this.welcomeService = welcomeService;
    }

    //List<Map<String, Object>> welcomeList = new ArrayList<>();
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return welcomeService.createWelcome(params);
        /*
        이전에 컨트롤러 필드에 저장해보는 코드

        String title = (String) params.get("title");
        String content = params.get("content") + "";
        String author = params.get("author") + "";
        int order = welcomeList.size();

        Map<String, Object> welcomeMap = new HashMap<>();
        welcomeMap.put("order", ++order);
        welcomeMap.put("title", title);
        welcomeMap.put("content", content);
        welcomeMap.put("author", author);
        welcomeList.add(welcomeMap);

        System.out.println(welcomeList);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        */
    }
    @GetMapping("/list")
    public List<Welcome> list1(){
        return list1();
        //return welcomeList;
    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Welcome detail(@RequestParam Integer id){
        return welcomeService.detailWelcome(id);
        /*int index = Integer.parseInt(order) - 1;
        Map<String, Object> welcomeMap = welcomeList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        resultMap.put("detail_welcome", welcomeMap);
        return resultMap;
        */

    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        /*
        int index = Integer.parseInt(params.get("order") + "") - 1;
        Map<String, Object> welcomeMap = welcomeList.get(index);
        welcomeMap.put("title", params.get("title"));
        welcomeMap.put("content", params.get("content"));
        welcomeMap.put("author", params.get("author"));
        //welcomeList.add

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        //resultMap.put("detail_welcome", welcomeMap);

        return resultMap;
        */
        return welcomeService.updateWelcome(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return welcomeService.deleteWelcome(Integer.parseInt(params.get("id") + ""));
    }
}