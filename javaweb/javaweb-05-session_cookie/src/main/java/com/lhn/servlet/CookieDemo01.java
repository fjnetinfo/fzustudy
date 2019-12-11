package com.lhn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();//从请求中获得cookies
        if (cookies != null) {
            out.write("上次访问的时间");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastLoginTime")) {//获得cookies的key
                    long lastLoginTime = Long.parseLong(cookie.getValue());//获取cookies的值
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.print("第一次访问");
        }
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");//新建cookies
        cookie.setMaxAge(24 * 60 * 60);//设置有效期(不设置有效期,浏览器关闭后就清空)
        resp.addCookie(cookie);//响应cookies
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
