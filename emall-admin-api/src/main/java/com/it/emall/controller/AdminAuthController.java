package com.it.emall.controller;

/**
 * @author libingyang
 * @create 2023/1/12 16:58
 */

import com.it.emall.domain.AdminUser;
import com.it.emall.mapper.UserMapper;
import com.it.emall.service.AdminUserService;
import com.it.emall.util.AjaxResult;
import com.it.emall.util.JwtHelper;
import com.it.emall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台登录认证接口
 */
@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {


    @Autowired
    private AdminUserService adminUserService;

    /**
     * 登录接口
     * @param adminUser  接收到的用户名和密码
     * @return 返回登录结果
     */
    @PostMapping("/login")
    public Object login(@RequestBody AdminUser adminUser){//接收json格式参数@RequestBody
        //调用Service
        AdminUser loginUser = adminUserService.login(adminUser.getUsername());
        String mi = MD5Utils.md5(adminUser.getPassword());
        System.out.println("密文:" + mi);
        if(loginUser != null && loginUser.getPassword().equals(mi)){
            System.out.println("登录成功!");
            Map<String,Object> data = new HashMap<>();
            data.put("token", JwtHelper.createToken(loginUser.getId().longValue()));
            Map<String,Object> adminInfo = new HashMap<>();
            adminInfo.put("nickName",loginUser.getUsername());
            adminInfo.put("avatar", loginUser.getAvatar());
            data.put("adminInfo", adminInfo);
            return AjaxResult.success(data);
        }else{
            System.out.println("用户名或者密码错误~~");
            return AjaxResult.fail(AjaxResult.INVALID_USER_INFO, "用户名或者密码错误~~");
        }
    }

    @GetMapping("/info")
    public Object info(@RequestHeader("X-Litemall-Admin-Token") String token){
        Long userId = JwtHelper.verifyTokenAndGetUserId(token);
        AdminUser user = adminUserService.selectUserById(userId.intValue());
        Map<String,Object> data = new HashMap<>();
        data.put("name", user.getUsername());
        data.put("avatar", user.getAvatar());
        data.put("roles",new String[]{});
        data.put("perms",new String[]{});
        return AjaxResult.success(data);
    }

}