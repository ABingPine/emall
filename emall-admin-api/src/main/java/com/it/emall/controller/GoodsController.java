package com.it.emall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.emall.domain.Goods;
import com.it.emall.domain.GoodsCategory;
import com.it.emall.service.GoodsService;
import com.it.emall.util.AjaxResult;
import com.it.emall.vo.GoodsCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author libingyang
 * @create 2023/1/13 15:20
 */

/**
 * 商品Controller
 */

@RestController
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     * @param goodsId
     * @param goodsSn
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public Object list(Integer goodsId,Integer goodsSn,String name,
                       @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                       @RequestParam(value = "limit", required = false, defaultValue = "10")Integer limit)
    {
        PageHelper.startPage(page,limit);
        List<Goods> list = goodsService.selectGoodsList(goodsId,goodsId,name);
        PageInfo<Goods> pageInfo = new PageInfo<>(list);//分页结果
        //组织data数据
        Map<String,Object> data = new HashMap<>();
        data.put("list", pageInfo.getList());
        data.put("total", pageInfo.getTotal() );
        data.put("pages", pageInfo.getPages());
        data.put("page", pageInfo.getPageNum() );
        data.put("limit", pageInfo.getPageSize());

        return AjaxResult.success(data);
    }

}
