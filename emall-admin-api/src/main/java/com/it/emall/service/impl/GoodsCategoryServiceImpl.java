package com.it.emall.service.impl;

import com.it.emall.domain.GoodsCategory;
import com.it.emall.mapper.GoodsCategoryMapper;
import com.it.emall.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author libingyang
 * @create 2023/1/12 21:52
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> selectCategoryList() {
        return goodsCategoryMapper.selectCategoryList();
    }

    @Override
    public List<GoodsCategory> selectChildrenCategoryByPid(Integer pid) {
        return goodsCategoryMapper.selectChildrenCategoryByPid(pid);
    }

    @Override
    public int insertCategory(GoodsCategory category) {
        return goodsCategoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(GoodsCategory category) {
        return goodsCategoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategory(Integer id) {
        return goodsCategoryMapper.deleteCategory(id);
    }

    @Override
    public GoodsCategory selectCategoryById(Integer id) {
        return goodsCategoryMapper.selectCategoryById(id);
    }
}
