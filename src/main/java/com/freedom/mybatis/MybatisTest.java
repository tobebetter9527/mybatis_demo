package com.freedom.mybatis;

import com.freedom.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author tobebetter9527
 * @description 测试类
 * @create 2020/04/13 22:52
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        try {
            // 指定配置文件
            String resource = "mybatis-config.xml";
            // 读取配置文件
            InputStream is = Resources.getResourceAsStream(resource);
            // 构建SqlSessionFactory
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            // 获得sqlSession
            sqlSession = build.openSession();
            // 执行查询操作，获取结果集。参数：1-命名空间（namespace）+“.”+statementId,2-sql的占位符参数
            User user = getUser(sqlSession);
            System.out.println(user);
        } finally {
            // 关闭连接
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    private static User getUser(SqlSession sqlSession) {
        return sqlSession.selectOne("UserMapper.queryUserById", 1L);
    }
}
