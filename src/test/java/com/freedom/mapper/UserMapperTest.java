package com.freedom.mapper;

import com.freedom.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/04/14 21:56
 */
public class UserMapperTest {
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        // 读取mybatis的全局配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 初始化userDao
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}