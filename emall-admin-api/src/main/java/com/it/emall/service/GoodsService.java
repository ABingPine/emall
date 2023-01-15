package com.it.emall.service;

/**
 * @author libingyang
 * @create 2023/1/13 15:08
 */

import com.it.emall.domain.Goods;

import java.util.List;

/**
 * 商品Service
 */
public interface GoodsService {

    List<Goods> selectGoodsList(Integer goodsId, Integer goodsSn, String name);

}
