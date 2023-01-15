package com.it.emall.domain;

/**
 * @author libingyang
 * @create 2023/1/12 21:36
 */

import lombok.Data;

import java.util.Date;

/**
 * 商品分类
 */
@Data
public class GoodsCategory {

    private Integer id;
    private String name;
    private String keywords;
    private String desc;
    private Integer pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    private Integer sortOrder;
    private Date addTime;
    private Date updateTime;
    private Integer deleted;

}
