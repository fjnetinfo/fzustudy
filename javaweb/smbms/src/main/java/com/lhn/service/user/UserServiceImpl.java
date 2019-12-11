package com.lhn.service.user;

import com.lhn.dao.BaseDao;
import com.lhn.dao.user.UserDao;
import com.lhn.dao.user.UserDaoImpl;
import com.lhn.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
        user = userDao.getLoginUser(connection, userCode);
        BaseDao.closeResource(connection, null, null);
        return user;
    }

}
