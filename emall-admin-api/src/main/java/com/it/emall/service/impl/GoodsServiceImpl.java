package com.it.emall.service.impl;

import com.it.emall.domain.Goods;
import com.it.emall.mapper.GoodsCategoryMapper;
import com.it.emall.mapper.GoodsMapper;
import com.it.emall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author libingyang
 * @create 2023/1/13 15:10
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoodsList(Integer goodsId, Integer goodsSn, String name) {
        return goodsMapper.selectGoodsList(goodsId,goodsSn,name);
    }
}
