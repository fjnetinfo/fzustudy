package com.lhn.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login";
        String sqlUsername = "root";
        String sqlPassword = "rootroot";
        //1加载驱动
        DriverManager.registerDriver(new Driver());
        //2连接数据库
        Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
        //3预编译SQL
        String sql = "insert into login.user(username,password) values(?,?);";
        //4创建CRUD对象,预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5赋值
        preparedStatement.setString(1,"user4");
        preparedStatement.setString(2,"102030");
        //6执行
        boolean b = preparedStatement.execute();
        //7关闭数据库
        preparedStatement.close();
        connection.close();
    }
}
