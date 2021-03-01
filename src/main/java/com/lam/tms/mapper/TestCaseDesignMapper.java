package com.lam.tms.mapper;


import com.lam.tms.entity.TestCaseDesign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试用例设计Mapper
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */
@Mapper
@Repository
public interface TestCaseDesignMapper {
    int deleteById(Long id);

    int createCase(TestCaseDesign newCase);

    TestCaseDesign getById(Long id);

    int updateById(Long id);

    List<TestCaseDesign> getTestCaseDesignList();
}
