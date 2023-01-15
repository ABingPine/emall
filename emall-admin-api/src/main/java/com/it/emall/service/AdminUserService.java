package com.it.emall.service;

/**
 * @author libingyang
 * @create 2023/1/12 18:41
 */

import com.it.emall.domain.AdminUser;

/**
 * 后台用户Service接口
 */
public interface AdminUserService {

    AdminUser login(String username);

    AdminUser selectUserById(Integer id);


}
