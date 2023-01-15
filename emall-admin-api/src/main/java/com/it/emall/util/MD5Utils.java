package com.it.emall.util;

/**
 * @author libingyang
 * @create 2023/1/12 17:45
 */

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 */
public class MD5Utils {


    /**
     * 加密
     * @param ming 明文
     * @return 返回密文
     */
    public static String md5(String ming) {
        return DigestUtils.md5DigestAsHex(ming.getBytes());
    }

}
