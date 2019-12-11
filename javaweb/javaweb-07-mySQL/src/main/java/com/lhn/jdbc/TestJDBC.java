package com.lhn.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login";
        String sqlUsername = "root";
        String sqlPassword = "rootroot";
        //1加载驱动
        DriverManager.registerDriver(new Driver());
        //2连接数据库
        Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
        //3创建CRUD对象
        Statement statement = connection.createStatement();
        //4编写SQL语句
        String sql = "select * from login.user;";
        //String sql="delete from login.user where username = user3;";
        //5执行得到结果集
        ResultSet resultSet = statement.executeQuery(sql);
        //int i = statement.executeUpdate(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("username"));
            System.out.println(resultSet.getObject("password"));
        }
        //6关闭数据库
        resultSet.close();
        statement.close();
        connection.close();
    }
}
