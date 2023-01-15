package com.it.emall.service;

/**
 * @author libingyang
 * @create 2023/1/12 21:51
 */

import com.it.emall.domain.GoodsCategory;

import java.util.List;

/**
 * 商品分类Service
 */
public interface GoodsCategoryService {

    /**
     * 分类列表
     * @return
     */
    List<GoodsCategory> selectCategoryList();

    /**
     * 查询子分类
     */
    List<GoodsCategory> selectChildrenCategoryByPid(Integer pid);

    /**
     * 添加分类
     */
    int insertCategory(GoodsCategory category);

    /**
     * 修改分类
     * @param category
     * @return
     */
    int updateCategory(GoodsCategory category);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteCategory(Integer id);

    /**
     * 通过id插叙分类
     */
    GoodsCategory selectCategoryById(Integer id);

}
