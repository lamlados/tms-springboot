package com.lam.tms.service.impl;

import com.lam.tms.entity.TestItemClassification;
import com.lam.tms.mapper.TestItemClassificationMapper;
import com.lam.tms.service.TestItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/28 12:53
 */
@Service
public class TestItemClassificationServiceImpl implements TestItemClassificationService {
    @Autowired
    TestItemClassificationMapper testItemClassificationMapper;
    @Override
    public List<TestItemClassification> generateMark(String itemName){
        return testItemClassificationMapper.generateMark(itemName);
    };
}
