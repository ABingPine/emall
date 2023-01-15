package com.it.emall.service.impl;

import com.it.emall.mapper.DashboardMapper;
import com.it.emall.service.DashboardService;
import com.it.emall.vo.DashboardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author libingyang
 * @create 2023/1/12 21:12
 */

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardMapper dashboardMapper;

    @Override
    public DashboardVo selectDashboardData() {
        return dashboardMapper.selectDashboardData();
    }
}
