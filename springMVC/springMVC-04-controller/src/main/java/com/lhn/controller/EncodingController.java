package com.lhn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EncodingController {
    @PostMapping("/e/t1")
    public String test(String name, Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test1";
    }
}
