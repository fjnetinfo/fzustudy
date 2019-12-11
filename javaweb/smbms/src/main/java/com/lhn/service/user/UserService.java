package com.lhn.service.user;

import com.lhn.pojo.User;

import java.sql.SQLException;

public interface UserService {
    public User login(String userCode, String password) throws SQLException, ClassNotFoundException;
}
