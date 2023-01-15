package com.it.emall.mapper;

/**
 * @author libingyang
 * @create 2023/1/13 14:50
 */

import com.it.emall.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品Mapper
 */
public interface GoodsMapper {

    List<Goods> selectGoodsList(@Param("goodsId") Integer goodsId,@Param("goodsSn") Integer goodSn,@Param("name") String name);

}
