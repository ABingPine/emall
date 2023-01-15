package com.it.emall.service.impl;

/**
 * @author libingyang
 * @create 2023/1/12 18:47
 */

import com.it.emall.domain.AdminUser;
import com.it.emall.mapper.UserMapper;
import com.it.emall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台用户Service实现
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired // 把UserMapper类型的对象自动注入进来
    private UserMapper userMapper;

    @Override
    public AdminUser login(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public AdminUser selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}
