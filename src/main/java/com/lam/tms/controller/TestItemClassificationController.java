package com.lam.tms.controller;

import com.lam.tms.entity.TestItemClassification;
import com.lam.tms.service.TestCaseDesignService;
import com.lam.tms.service.TestItemClassificationService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/28 12:55
 */
@Slf4j
@Api(tags = "[ 业务内容 ] 标识生成")
@RestController
@RequestMapping("/system/mark")
public class TestItemClassificationController {

    @Autowired
    private TestItemClassificationService testItemClassificationService;
    @Autowired
    private TestCaseDesignService testCaseDesignService;

    @ApiOperation(value = "生成标识", notes = "根据能力点生成标识")
    @PostMapping("/generateMark")
    public JsonResult<UserVo> generateMark(String currentAbility, String itemName) {
        List<TestItemClassification> markList = testItemClassificationService.generateMark(itemName);
        TestItemClassification tic = markList.get(0);
        String curMark = tic.getItemMark() + "-" + currentAbility +  "-" + tic.getBigMark()+ "-"
                       + tic.getMediumMark() + "-" + tic.getSmallMark();
        System.out.println(curMark);
        int result = testCaseDesignService.checkMark(curMark);
        System.out.println(result);
        return JsonResult.success(curMark + "-" + (result + 1));
    }
}
