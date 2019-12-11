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
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.selectUser();
    }
}
