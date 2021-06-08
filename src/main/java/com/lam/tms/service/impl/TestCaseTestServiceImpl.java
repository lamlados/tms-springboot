package com.lam.tms.service.impl;

import com.lam.tms.entity.TestCaseTest;
import com.lam.tms.mapper.TestCaseTestMapper;
import com.lam.tms.service.TestCaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseTestServiceImpl implements TestCaseTestService {

    @Autowired
    private TestCaseTestMapper testCaseTestMapper;

    @Override
    public int deleteById(Integer id) { return testCaseTestMapper.deleteById(id); }

    @Override
    public int updateCase(TestCaseTest testCase) { return testCaseTestMapper.updateCase(testCase); }

    @Override
    public List<TestCaseTest> getAllList() { return testCaseTestMapper.getAllList(); }

    @Override
    public int createCase(TestCaseTest newCase) { return testCaseTestMapper.createCase(newCase); }
}
