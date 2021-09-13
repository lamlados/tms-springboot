package com.lam.tms.service;


import com.lam.tms.entity.TestCaseTest;

import java.util.List;

public interface TestCaseTestService {

    int deleteById(Integer id);

    int updateCase(TestCaseTest testCase);

    List<TestCaseTest> getAllList();

    int createCase(TestCaseTest newCase);

}
