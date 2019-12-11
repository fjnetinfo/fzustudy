package com.lhn.mapper;

import com.lhn.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        User user = new User(5,"罗","35623421");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        userMapper.deleteUser(4);

        return userMapper.selectUser();
    }

    public int addUser(User user) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.addUser(user);
    }

    public int deleteUser(int id) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.deleteUser(id);
    }
}
