package com.lam.tms.service;

import com.lam.tms.entity.TestItemClassification;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/28 12:52
 */
public interface TestItemClassificationService {
    List<TestItemClassification> generateMark(String itemName);
}
