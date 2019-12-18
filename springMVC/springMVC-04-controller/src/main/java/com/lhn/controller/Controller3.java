package com.lhn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class Controller3 {
    @RequestMapping("/t1")
    public String test(){
        return "test1";
    }
}
