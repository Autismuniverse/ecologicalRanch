package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Address;
import com.ecologicalRanch.project.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
@Validated
@Slf4j
public class AddressController {



    /**
     * githubTest
     */

    @Autowired
    private AddressService addressService;

//    /**
//     * 根据id查询
//     */
//    @ApiOperation(value = "根据id查询数据")
//    @GetMapping(value = "/test")
//    @ResponseBody
//    public CommonResult test(String username,String password){
//
//        if (username.equals("123") && password.equals("123")){
//        return CommonResult.success("登陆成功");
//        }
//
//        System.out.println("账号："+username+"密码："+password);
//        return CommonResult.failed("账号是123，你输成了："+username+"+++++++++++++++密码是123，你输成了："+password);
//    }

    /**
     * 查询Address列表
     */
    @ApiOperation(" 查询Address列表")
    @PostMapping("/selectAddressList")
    @ResponseBody
    public CommonResult selectAddressList(@RequestBody Address address,
                                          @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        try{

            return CommonResult.success(CommonPage.restPage(addressService.selectAddressList(address,pageNum,pageSize)));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 通过Id查询Address
     */
    @ApiOperation("通过Id查询Address")
    @PostMapping("/selectAddressById")
    @ResponseBody
    public CommonResult selectAddressById(@RequestBody Address address){
        try{return CommonResult.success(addressService.selectAddressById(address.getAddressId()));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }



    /**
     * 新增Address
     */
    @ApiOperation("新增Address")
    @PostMapping("/insertAddress")
    @ResponseBody
    public CommonResult insertAddress(@RequestBody @Validated Address address){
        try{return CommonResult.success(addressService.insertAddress(address));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 修改Address信息
     */
    @ApiOperation("修改Address信息")
    @PostMapping("/updateAddress")
    @ResponseBody
    public CommonResult updateAddress(@RequestBody Address address){
        try{return CommonResult.success(addressService.updateAddress(address));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 通过id删除Address
     */
    @ApiOperation("通过id删除Address")
    @PostMapping("/deleteAddressById")
    @ResponseBody
    public CommonResult deleteAddressById(Long addressId){
        try{return CommonResult.success(addressService.deleteAddressById(addressId));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 通过id批量删除Address
     */
    @ApiOperation("通过id批量删除Address")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteAddressByIds(@RequestBody String addressIds){
        try{return CommonResult.success(addressService.deleteAddressByIds(addressIds));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }


    /**
     * 通过userId查询默认Address
     */
    @ApiOperation("通过userId查询默认Address")
    @PostMapping("/selectDefaultAddressByUserId")
    @ResponseBody
    public CommonResult selectDefaultAddressByUserId(@RequestBody Address address){
        try{if(addressService.selectDefaultAddressByUserId(address)==null) {
            return CommonResult.success(addressService.selectDefaultAddressByUserIdElse(address));
        }
        return CommonResult.success(addressService.selectDefaultAddressByUserId(address));}
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

//    /**
//     * 修改Address信息
//     */
//    @ApiOperation("修改默认Address")
//    @PostMapping("/updateDefaultAddress")
//    @ResponseBody
//    public CommonResult updateDefaultAddress(@RequestBody Address address){
//        return CommonResult.success(addressService.updateDefaultAddress(address));
//    }
}

