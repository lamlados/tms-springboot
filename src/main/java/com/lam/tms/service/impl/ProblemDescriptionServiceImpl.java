package com.lam.tms.service.impl;

import com.lam.tms.entity.ProblemDescription;
import com.lam.tms.mapper.ProblemDescriptionMapper;
import com.lam.tms.service.ProblemDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/2/28 22:51
 */
@Service
public class ProblemDescriptionServiceImpl implements ProblemDescriptionService {
    @Autowired
    private ProblemDescriptionMapper problemDescriptionMapper;

    @Override
    public List<ProblemDescription> getAllList() {
        return problemDescriptionMapper.getAllList();
    }

    @Override
    public List<ProblemDescription> getListByMark(String caseMark) { return problemDescriptionMapper.getListByMark(caseMark); }

    @Override
    public int deleteById(Integer id) { return problemDescriptionMapper.deleteById(id); }

    @Override
    public int updateProblem(ProblemDescription problemDescription) { return problemDescriptionMapper.updateProblem(problemDescription); }

    @Override
    public int createCase(ProblemDescription newCase) { return problemDescriptionMapper.createCase(newCase); }

    @Override
    public int checkMark(String curMark) { return problemDescriptionMapper.checkMark(curMark); }
}
