package com.lhn;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=utf-8";

        String sql = "select username,password from login.user where username=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "rootroot");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                String sqlPassword = resultSet.getString("password");
                if (password.equals(sqlPassword)) {
                    JSONObject jsonSuccess = new JSONObject();
                    jsonSuccess.put("code","200");
                    jsonSuccess.put("msg","登入成功");
                    resp.getWriter().print(jsonSuccess);
                    System.out.println(JSON.toJSONString(jsonSuccess));
                } else {
                    JSONObject jsonSuccess = new JSONObject();
                    jsonSuccess.put("code","201");
                    jsonSuccess.put("msg","密码错误");
                    resp.getWriter().print(jsonSuccess);
                    System.out.println(JSON.toJSONString(jsonSuccess));
                }
            } else {
                JSONObject jsonSuccess = new JSONObject();
                jsonSuccess.put("code","202");
                jsonSuccess.put("msg","用户不存在");
                resp.getWriter().print(jsonSuccess);
                System.out.println(JSON.toJSONString(jsonSuccess));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(req.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);

        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=utf-8";

        String sql = "select username,password from login.user where username=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "rootroot");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                String sqlPassword = resultSet.getString("password");
                if (password.equals(sqlPassword)) {
                    JSONObject jsonSuccess = new JSONObject();
                    jsonSuccess.put("code","200");
                    jsonSuccess.put("msg","登入成功");
                    resp.getWriter().print(jsonSuccess);
                    System.out.println(JSON.toJSONString(jsonSuccess));
                } else {
                    JSONObject jsonSuccess = new JSONObject();
                    jsonSuccess.put("code","201");
                    jsonSuccess.put("msg","密码错误");
                    resp.getWriter().print(jsonSuccess);
                    System.out.println(JSON.toJSONString(jsonSuccess));
                }
            } else {
                JSONObject jsonSuccess = new JSONObject();
                jsonSuccess.put("code","202");
                jsonSuccess.put("msg","用户不存在");
                resp.getWriter().print(jsonSuccess);
                System.out.println(JSON.toJSONString(jsonSuccess));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
