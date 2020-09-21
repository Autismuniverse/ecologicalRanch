package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Gateway;
import com.ecologicalRanch.project.service.GatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 14:54:24'
 */
@Api(tags = "网关")
@Controller
@RequestMapping("/app/gateway")
@Slf4j
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    /**
     * 查询Gateway列表
     */
    @ApiOperation(" 查询Gateway列表")
    @PostMapping("/selectGatewayList")
    @ResponseBody
    public CommonResult selectGatewayList(@RequestBody Gateway gateway,
                                          @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        try{
            return CommonResult.success(CommonPage.restPage(gatewayService.selectGatewayList(gateway,pageNum,pageSize)));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过Id查询Gateway
     */
    @ApiOperation("通过Mac查询Gateway")
    @PostMapping("/selectGatewayByMac")
    @ResponseBody
    public CommonResult selectGatewayById(@RequestBody Gateway gateway){
        try{
            return CommonResult.success(gatewayService.selectGatewayByMac(gateway));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 新增Gateway
     */
    @ApiOperation("新增Gateway")
    @PostMapping("/insertGateway")
    @ResponseBody
    public CommonResult insertGateway(@RequestBody Gateway gateway){
        try{
            return CommonResult.success(gatewayService.insertGateway(gateway));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 修改Gateway信息
     */
    @ApiOperation("修改Gateway信息")
    @PostMapping("/updateGateway")
    @ResponseBody
    public CommonResult updateGateway(Gateway gateway){
        try{
            return CommonResult.success(gatewayService.updateGateway(gateway));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id删除Gateway
     */
    @ApiOperation("通过id删除Gateway")
    @PostMapping("/deleteGatewayById/{gatewayId}")
    @ResponseBody
    public CommonResult deleteGatewayById(@PathVariable("gatewayId") Long gatewayId){
        try{
            return CommonResult.success(gatewayService.deleteGatewayById(gatewayId));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id批量删除Gateway
     */
    @ApiOperation("通过id批量删除Gateway")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteGatewayByIds(String gatewayIds){
        try{
            return CommonResult.success(gatewayService.deleteGatewayByIds(gatewayIds));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }
}
