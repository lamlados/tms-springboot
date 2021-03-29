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

    int deleteById(Integer id);

    int updateCase(TestCaseDesign testCase);

    List<TestCaseDesign> getAllList();

    int createCase(TestCaseDesign newCase);

    List<TestCaseDesign> getListByMark(String caseMark);

    int checkMark(String curMark);

}
