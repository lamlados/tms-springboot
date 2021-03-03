package com.lam.tms.service;

import com.lam.tms.entity.TestCaseDesign;

import java.util.List;

/**
 * 测试用例设计Service
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


public interface TestCaseDesignService {
    List<TestCaseDesign> getTestCaseDesignList();
    int deleteById(Long id);
}
