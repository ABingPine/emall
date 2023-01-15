package com.it.emall.mapper;

/**
 * @author libingyang
 * @create 2023/1/11 16:07
 */

import com.it.emall.domain.AdminUser;

/**
 * 用户信息Mapper接口
 */
public interface UserMapper {

    /**
     * 通过用户名来查询用户信息
     * @param username 用户名
     * @return 返回用户信息
     */

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 返回用户信息
     */
    AdminUser selectUserByUsername(String username);

    /**
     * 通过ID查询用户信息
     * @param id 用户ID
     * @return 返回用户信息
     */
    AdminUser selectUserById(Integer id);

}
