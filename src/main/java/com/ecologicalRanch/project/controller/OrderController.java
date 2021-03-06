package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Order;
import com.ecologicalRanch.project.service.OrderService;
import com.ecologicalRanch.project.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
@Api(tags = "订单接口")
@Controller
@RequestMapping("/app/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PriceService priceService;


    /**
     * 查询Order列表
     */
    @ApiOperation(" 查询Order列表")
    @PostMapping("/selectOrderList")
    @ResponseBody
    public CommonResult selectOrderList(@RequestBody Order order,
                                        @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        try {
            return CommonResult.success(CommonPage.restPage(orderService.selectOrderList(order, pageNum, pageSize)));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过Id查询Order
     */
    @ApiOperation("通过Id查询Order")
    @PostMapping("/selectOrderById")
    @ResponseBody
    public CommonResult selectOrderById(@RequestBody Long orderId) {
        try {
            return CommonResult.success(orderService.selectOrderById(orderId));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 新增Order
     */
    @ApiOperation("新增Order")
    @PostMapping("/insertOrder")
    @ResponseBody
    public CommonResult insertOrder(@RequestBody Order order) {
        if (orderService.insertOrder(order) == 0) {
            return CommonResult.failed("添加失败");
        } else
            return CommonResult.success("添加成功");
    }

    /**
     * 修改Order信息
     */
    @ApiOperation("取消订单")
    @PostMapping("/cancelDelivery")
    @ResponseBody
    public CommonResult cancelDelivery(@RequestBody Order order) {
//        try {
            return CommonResult.success(orderService.cancelDelivery(order));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return CommonResult.failed("未知错误");
//        }
    }

    /**
     * 取消订单
     */
    @ApiOperation("修改Order信息")
    @PostMapping("/updateOrder")
    @ResponseBody
    public CommonResult updateOrder(@RequestBody @Validated Order order) {
        try {
            return CommonResult.success(orderService.updateOrder(order));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }


    /**
     * 通过id删除Order
     */
    @ApiOperation("通过id删除Order")
    @PostMapping("/deleteOrderById/{orderId}")
    @ResponseBody
    public CommonResult deleteOrderById(@PathVariable("orderId") Long orderId) {
        try {
            return CommonResult.success(orderService.deleteOrderById(orderId));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id批量删除Order
     */
    @ApiOperation("通过id批量删除Order")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteOrderByIds(String orderIds) {
        try {
            return CommonResult.success(orderService.deleteOrderByIds(orderIds));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 根据Order查询field
     */
    @ApiOperation("查询Order中其他")
    @PostMapping("/selectOrderInfoListByUserId")
    @ResponseBody
    public CommonResult selectOrderInfoListByUserId(@RequestBody Order order,
                                                    @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        try {
            return CommonResult.success(CommonPage.restPage(orderService.selectOrderInfoListByUserId(order, pageNum, pageSize)));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }
}
