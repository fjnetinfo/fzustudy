package com.lhn.controller;

import com.lhn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    //Localhost:8080/user/t1?name=xxxx
    public String test(@RequestParam("username") String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test1";
    }
    @GetMapping("/t2")
    //localhost:8080/user/t2?id=1&name=xxx&age=1
    public String test2(User user, Model model) {
        System.out.println(user);
        model.addAttribute("msg", user);
        return "test1";
    }
}
