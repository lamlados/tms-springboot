package com.lam.tms.service.impl;

import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.mapper.TestCaseDesignMapper;
import com.lam.tms.service.TestCaseDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试用例设计Service 实现类
 * @author lamlados
 * @date 2021/2/20 15:26
 */
@Service
public class TestCaseDesignServiceImpl implements TestCaseDesignService {
    @Autowired
    private TestCaseDesignMapper testCaseDesignMapper;
    @Override
    public List<TestCaseDesign> getAllList() {
        return testCaseDesignMapper.getAllList();
    }

    @Override
    public List<TestCaseDesign> getListByMark(String caseMark) { return testCaseDesignMapper.getListByMark(caseMark); }

    @Override
    public int deleteById(Integer id) { return testCaseDesignMapper.deleteById(id); }

    @Override
    public int updateCase(TestCaseDesign testCase) { return testCaseDesignMapper.updateCase(testCase); }

    @Override
    public int checkMark(String curMark){ return testCaseDesignMapper.checkMark(curMark); }
    @Override
    public int createCase(TestCaseDesign newCase) { return testCaseDesignMapper.createCase(newCase); }

}
