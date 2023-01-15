package com.it.emall.vo;

/**
 * @author libingyang
 * @create 2023/1/12 21:03
 */

import lombok.Data;

/**
 * 仪表盘数据对象
 */
@Data
public class DashboardVo {

    private Integer goodsTotal;
    private Integer userTotal;
    private Integer productTotal;
    private Integer orderTotal;
}
