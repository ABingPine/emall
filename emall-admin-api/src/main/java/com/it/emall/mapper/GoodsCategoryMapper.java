package com.it.emall.mapper;

/**
 * @author libingyang
 * @create 2023/1/12 21:43
 */

import com.it.emall.domain.GoodsCategory;

import java.util.List;

/**
 * 商品分类Mapper
 */
public interface GoodsCategoryMapper {

    /**
     * 查询分类列表(一级)
     * @return
     */
    List<GoodsCategory> selectCategoryList();

    /**
     * 通过夫分类ID查询子分类
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
