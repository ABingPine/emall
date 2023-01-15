package com.it.emall.controller;

/**
 * @author libingyang
 * @create 2023/1/12 21:54
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.emall.domain.GoodsCategory;
import com.it.emall.mapper.GoodsCategoryMapper;
import com.it.emall.service.GoodsCategoryService;
import com.it.emall.util.AjaxResult;
import com.it.emall.vo.CategorySelectVo;
import com.it.emall.vo.GoodsCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 商品分类Controller
 */
@RestController
@RequestMapping("/admin/category")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/list")
    public Object list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                       @RequestParam(value = "limit", required = false, defaultValue = "10")Integer limit){
        //分页
        PageHelper.startPage(page, limit);
        List<GoodsCategory> list = goodsCategoryService.selectCategoryList();
        PageInfo<GoodsCategory> pageInfo = new PageInfo<>(list);//分页结果
        //组织data数据
        Map<String,Object> data = new HashMap<>();
        //组织Vo
        List<GoodsCategory> level1List = pageInfo.getList();
        List<GoodsCategoryVo> voList = new ArrayList<>();
        //查询一级分类下的二级分类
        for(GoodsCategory l1 : level1List){
            List<GoodsCategory> children =  goodsCategoryService.selectChildrenCategoryByPid(l1.getId());
            GoodsCategoryVo vo = new GoodsCategoryVo();
            vo.setId(l1.getId());
            vo.setName(l1.getName());
            vo.setKeywords(l1.getKeywords());
            vo.setDesc(l1.getDesc());
            vo.setIconUrl(l1.getIconUrl());
            vo.setPicUrl(l1.getPicUrl());
            vo.setLevel(l1.getLevel());
            vo.setChildren(children);
            voList.add(vo);
        }
        data.put("list", voList);
        data.put("total", pageInfo.getTotal() );
        data.put("pages", pageInfo.getPages());
        data.put("page", pageInfo.getPageNum() );
        data.put("limit", pageInfo.getPageSize());
        return AjaxResult.success(data);
    }

    /**
     * 添加
     * @param category
     * @return
     */
    @PostMapping("/create")
    public Object add(@RequestBody GoodsCategory category) {
        category.setAddTime(new Date()); // 添加时间
        category.setUpdateTime(category.getUpdateTime());
        category.setDeleted(0);
        if ((category.getKeywords() == null)) {
            category.setKeywords("");
        }

        int rows = goodsCategoryService.insertCategory(category);
        if(rows > 0){
            return AjaxResult.success();
        }else{
            return AjaxResult.fail();
        }
    }

    /**
     * 修改
     * @param category
     * @return
     */
    @PostMapping("/update")
    public Object edit(@RequestBody GoodsCategory category) {
        category.setUpdateTime(new Date());

        int rows = goodsCategoryService.insertCategory(category);
        if (rows > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.fail();
        }
    }

    /**
     * 删除
     * @param category
     * @return
     */
    @PostMapping("/delete")
    public Object delete(@RequestBody GoodsCategory category) {
        int rows = goodsCategoryService.deleteCategory(category.getId());

        if (rows > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.fail();
        }
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("/read")
    public Object detail(Integer id) {
        GoodsCategory category = goodsCategoryService.selectCategoryById(id);
        return AjaxResult.success(category);
    }

    @GetMapping("l1")
    public Object level1List() {
        List<GoodsCategory> list = goodsCategoryService.selectCategoryList();
        List<CategorySelectVo> voList = new ArrayList<>();
        for (GoodsCategory category : list) {
            CategorySelectVo vo = new CategorySelectVo();
            vo.setLabel(category.getName());
            vo.setValue(category.getId());
            voList.add(vo);
        }
        Map<String,Object> data = new HashMap<>();
        data.put("list",voList);
        return AjaxResult.success(data);
    }

}
