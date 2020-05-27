package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Address;
import com.ecologicalRanch.project.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:49:45'
 */
@Api(tags = "收货地址")
@Controller
@RequestMapping("/app/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 查询Address列表
     */
    @ApiOperation(" 查询Address列表")
    @PostMapping("/selectAddressList")
    @ResponseBody
    public CommonResult selectAddressList(@RequestBody Address address,
                                          @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(addressService.selectAddressList(address,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Address
     */
    @ApiOperation("通过Id查询Address")
    @PostMapping("/selectAddressById")
    @ResponseBody
    public CommonResult selectAddressById(@RequestBody Long addressId){
        return CommonResult.success(addressService.selectAddressById(addressId));
    }

    /**
     * 新增Address
     */
    @ApiOperation("新增Address")
    @PostMapping("/insertAddress")
    @ResponseBody
    public CommonResult insertAddress(@RequestBody Address address){
        return CommonResult.success(addressService.insertAddress(address));
    }

    /**
     * 修改Address信息
     */
    @ApiOperation("修改Address信息")
    @PostMapping("/updateAddress")
    @ResponseBody
    public CommonResult updateAddress(@RequestBody Address address){
        return CommonResult.success(addressService.updateAddress(address));
    }

    /**
     * 通过id删除Address
     */
    @ApiOperation("通过id删除Address")
    @PostMapping("/deleteAddressById")
    @ResponseBody
    public CommonResult deleteAddressById(@RequestBody Long addressId){
        return CommonResult.success(addressService.deleteAddressById(addressId));
    }

    /**
     * 通过id批量删除Address
     */
    @ApiOperation("通过id批量删除Address")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteAddressByIds(@RequestBody String addressIds){
        return CommonResult.success(addressService.deleteAddressByIds(addressIds));
    }
}

