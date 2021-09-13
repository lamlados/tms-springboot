package com.lam.tms.service.impl;

import com.lam.tms.entity.TestItemMain;
import com.lam.tms.mapper.TestItemMainMapper;
import com.lam.tms.service.TestItemMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试项目Service 实现类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Service
public class TestItemMainServiceImpl implements TestItemMainService {

    @Autowired
    private TestItemMainMapper testItemMainMapper;

    @Override
    public List<TestItemMain> getTestItemMainList() {
        return testItemMainMapper.getTestItemMainList();
    }

    @Override
    public List<String> getNameList() {
        return testItemMainMapper.getNameList();
    }

}
