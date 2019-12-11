package com.lhn.servlet;

import com.lhn.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        session.setAttribute("name", new Person("张三",5));

        String id = session.getId();
        if (session.isNew()) {
            resp.getWriter().write("新的Session创建成功" + id);
        } else {
            resp.getWriter().write("已经存在" + id);
        }
    }
}
