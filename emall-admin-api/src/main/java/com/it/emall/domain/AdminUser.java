package com.it.emall.domain;

/**
 * @author libingyang
 * @create 2023/1/11 16:11
 */


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 后台用户的实体类
 */
@Data
public class AdminUser {
    private Integer id;
    private String username;
    private String password;
    private String lastLoginIp;
    private Date lastLoginTime;
    private String avatar;
    private Date addTime;
    private Date updateTime;
    private Integer deleted;
    private List<Integer> roleIds;



}
