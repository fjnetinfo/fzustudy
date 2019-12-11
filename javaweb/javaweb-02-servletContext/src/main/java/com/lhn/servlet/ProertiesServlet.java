package com.lhn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/database.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        resp.getWriter().print("用户名:" + username + "密码:" + password);

    }
}
