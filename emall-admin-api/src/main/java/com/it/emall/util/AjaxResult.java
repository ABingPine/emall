package com.it.emall.util;

/**
 * @author libingyang
 * @create 2023/1/12 18:09
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 统一的json结果的封装
 */
public class AjaxResult {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int INVALID_USER_INFO = 605;

    // 成功
    public static Map<String,Object> success() {
        Map<String,Object> result = new HashMap<>();
        result.put("errno",SUCCESS);
        result.put("emrrsg","成功");
        return result;
    }

    public static Map<String,Object> success(Object data) {
        Map<String,Object> result = new HashMap<>();
        result.put("errno",SUCCESS);
        result.put("emrrsg","成功");
        result.put("data",data);
        return result;
    }

    // 失败
    public static Map<String,Object> fail(){
        Map<String,Object> result = new HashMap<>();
        result.put("errno",FAIL);
        result.put("errmsg","失败");
        return result;
    }
    public static Map<String,Object> fail(int errno, String errmsg){
        Map<String,Object> result = new HashMap<>();
        result.put("errno",errno);
        result.put("errmsg",errmsg);
        return result;
    }
}
