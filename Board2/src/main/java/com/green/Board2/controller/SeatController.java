package com.green.Board2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seat")
public class SeatController {

    @GetMapping("/main")
    public String main(){
        return "seat_main";
    }


}
