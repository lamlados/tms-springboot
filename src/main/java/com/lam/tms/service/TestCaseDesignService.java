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

    List<TestCaseDesign> getAllList();

    List<TestCaseDesign> getListByMark(String caseMark);

    int deleteById(Integer id);

    int updateCase(TestCaseDesign testCase);

    int createCase(TestCaseDesign newCase);

    int checkMark(String curMark);

}
