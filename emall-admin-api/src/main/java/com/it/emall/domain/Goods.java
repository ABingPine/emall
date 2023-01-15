package com.it.emall.domain;

/**
 * @author libingyang
 * @create 2023/1/13 14:18
 */

import lombok.Data;

import java.util.Date;

/**
 * 商品类
 */
@Data
public class Goods {

    private Integer id;
    private Integer goods;
    private String name;
    private Integer categoryId;
    private Integer brandId;
    private String[] gallery;
    private String[] keywords;
    private String brief;
    private Boolean inOnSale;
    private Integer sortOrder;
    private String picUrl;
    private String shareUrl;
    private Boolean isNew;
    private Boolean isHot;
    private String unit;
    private Double counterPrice;
    private Double retailPrice;
    private String detail;
    private Date addTime;
    private Date updateTime;
    private Integer deleted;

}
