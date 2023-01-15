package com.it.emall.controller;

import com.it.emall.service.DashboardService;
import com.it.emall.util.AjaxResult;
import com.it.emall.vo.DashboardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libingyang
 * @create 2023/1/12 21:20
 */
@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/admin/dashboard")
    public Object findDashboardData() {
        DashboardVo dashboardVo = dashboardService.selectDashboardData();
        return AjaxResult.success(dashboardVo);
    }

}
