package com.lhn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class Model1 {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response){

        System.out.println(request.getSession().getId());
        //无视图解析,转发 return "forward:/WEB-INF/jsp/test1.jsp";
        //重定向
        return "redirect:/index.jsp";

    }
}
