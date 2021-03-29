package com.lam.tms.mapper;

import com.lam.tms.entity.TestItemClassification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/28 12:47
 */
@Mapper
@Repository
public interface TestItemClassificationMapper {
    List<TestItemClassification> generateMark(String itemName);
}
