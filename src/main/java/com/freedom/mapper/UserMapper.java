package com.freedom.mapper;

import com.freedom.entity.User;

import java.util.List;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/04/14 21:52
 */
public interface UserMapper {
    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);
}
