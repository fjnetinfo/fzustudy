package com.lhn.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC3 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login";
        String sqlUsername = "root";
        String sqlPassword = "rootroot";

        DriverManager.registerDriver(new Driver());

        Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
        connection.setAutoCommit(false);
        String sql = "update account.user set money=money-100 where id=1;";
        connection.prepareStatement(sql).executeUpdate();

        int i=1/0;

        String sql2 = "update account.user set money=money+100 where id=2;";
        connection.prepareStatement(sql2).executeUpdate();

        connection.commit();
    }
}
