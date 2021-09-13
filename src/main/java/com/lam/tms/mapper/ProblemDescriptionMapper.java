package com.lam.tms.mapper;

import com.lam.tms.entity.ProblemDescription;
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

    int createCase(ProblemDescription newCase);

    int deleteById(Integer id);

    int updateProblem(ProblemDescription problemDescription);

    List<ProblemDescription> getAllList();

    List<ProblemDescription> getListByMark(String problemMark);

    int checkMark(String curMark);

}
