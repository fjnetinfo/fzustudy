package com.lhn.service;

import com.lhn.dao.UserDao;
import com.lhn.dao.UserDaoImpl;
import com.lhn.dao.UserDaoMySQLImpl;
import com.lhn.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService {

    //private UserDao userDao = new UserDaoOracleImpl();

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
