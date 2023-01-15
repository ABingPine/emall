package com.it.emall.controller;

/**
 * @author libingyang
 * @create 2023/1/11 15:16
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试接口
 */
@RestController
public class TestController {

    // 一个方法就可以定义一个接口
    @RequestMapping(value = "/admin/test", method = RequestMethod.GET)
    public Object test(String username, String password) {
        // 输出参数
        System.out.println("username:" + username + " password:" + password);
        Map<String,String> json = new HashMap<>();
        json.put("errno","0");
        json.put("errmsg","成功");
        // 响应结果
        return json;
    }
}
