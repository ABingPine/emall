package com.it.emall.vo;

/**
 * @author libingyang
 * @create 2023/1/13 1:35
 */

import com.it.emall.domain.GoodsCategory;
import lombok.Data;

import java.util.List;

/**
 * 商品分类Vo(子分类包含在夫分类中)
 */
@Data
public class GoodsCategoryVo extends GoodsCategory {

    private List<GoodsCategory> children; // 子分类

}
