package com.lam.tms.mapper;

import com.lam.tms.common.mapper.BaseMapper;
import com.lam.tms.entity.TestItemMain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试项目Mapper
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */
@Mapper
@Repository
public interface TestItemMainMapper extends BaseMapper<TestItemMain, Integer> {

    List<TestItemMain> getTestItemMainList();

    List<String> getNameList();

}
