//package com.lam.tms.controller;
//
//import com.lam.tms.service.TestItemMainService;
//import com.lam.tms.util.JsonResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * 用户管理 控制器
// *
// * @author lamlados
// * @date 2021/2/20 15:26
// */
//
//@Slf4j
//@Api(tags = "[ 业务管理 ] 项目查询")
//@RestController
//@RequestMapping("/system")
//public class TestItemMainController {
//    @Autowired
//    private TestItemMainService testItemMainService;
//
//    @ApiOperation(value = "下拉内容", notes = "下拉内容")
//    @GetMapping("/testItem")
//    public JsonResult<List<String>> getItemList(){
//        List<String> list = testItemMainService.getNameList();
//        return JsonResult.success(list);
//    }
//}
