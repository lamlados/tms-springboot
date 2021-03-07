package com.lam.tms.mapper;

import com.lam.tms.entity.ProblemDescription;
import com.lam.tms.entity.TestCaseDesign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/2/28 22:47
 */
@Mapper
@Repository
public interface ProblemDescriptionMapper {
    List<ProblemDescription> getAllList();
    List<ProblemDescription> getListByMark(String caseMark);
}
