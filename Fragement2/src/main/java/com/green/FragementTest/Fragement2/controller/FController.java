package com.green.FragementTest.Fragement2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        return "content/list";
    }

    @GetMapping("/detail")
    public String detail(){
        return "content/detail";
    }


}
