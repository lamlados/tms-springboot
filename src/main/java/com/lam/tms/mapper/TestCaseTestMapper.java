package com.lam.tms.mapper;

import com.lam.tms.entity.TestCaseTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestCaseTestMapper {
    int deleteById(Integer id);

    int updateCase(TestCaseTest testCase);

    List<TestCaseTest> getAllList();

}
