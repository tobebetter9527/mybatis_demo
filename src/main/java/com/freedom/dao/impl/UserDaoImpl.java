package com.freedom.dao.impl;

import com.freedom.dao.UserDao;
import com.freedom.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/04/14 21:21
 */
public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Long id) {
        return this.sqlSession.selectOne("UserDaoMapper.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDaoMapper.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("UserDaoMapper.insertUser", user);
        this.sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDaoMapper.updateUser", user);
        this.sqlSession.commit();
    }

    @Override
    public void deleteUserById(Long id) {
        this.sqlSession.delete("UserDaoMapper.deleteUserById", id);
        this.sqlSession.commit();
    }
}
