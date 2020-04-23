package com.freedom.mybatis;

import com.freedom.dao.UserDao;
import com.freedom.dao.impl.UserDaoImpl;
import com.freedom.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/04/14 21:35
 */
public class UserDaoTest {
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 初始化userDao
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        User user = this.userDao.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setAge(18);
        user.setName("柳岩");
        user.setPassword("123456");
        user.setUserName("yanyan");
        user.setSex(3);
        user.setBirthday(new Date());
        this.userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
        // 查询
        User user = this.userDao.queryUserById(7l);
        // 更新
        user.setAge(28);
        user.setPassword("111111");
        this.userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        this.userDao.deleteUserById(7l);
    }
}