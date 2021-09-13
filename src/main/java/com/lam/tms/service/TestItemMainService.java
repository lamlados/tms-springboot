package com.lam.tms.service;

import com.lam.tms.entity.TestItemMain;

import java.util.List;

/**
 * 测试项目Service
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public interface TestItemMainService {

    List<TestItemMain> getTestItemMainList();

    List<String> getNameList();

}
