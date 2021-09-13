package com.lam.tms.service;

import com.lam.tms.entity.ProblemDescription;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/2/28 22:50
 */
public interface ProblemDescriptionService {

    List<ProblemDescription> getAllList();

    List<ProblemDescription> getListByMark(String caseMark);

    int deleteById(Integer id);

    int updateProblem(ProblemDescription problemDescription);

    int createCase(ProblemDescription newCase);

    int checkMark(String curMark);

}
