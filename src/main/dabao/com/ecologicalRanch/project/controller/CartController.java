package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Cart;
import com.ecologicalRanch.project.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xxxfredyang
 * @date '2020-06-27 16:34:04'
 */
@Api(tags = "购物车")
@Controller
@RequestMapping("/app/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 查询Cart列表
     */
    @ApiOperation(" 查询Cart列表")
    @PostMapping("/selectCartList")
    @ResponseBody
    public CommonResult selectCartList(Cart cart,
                                       @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        try {
            return CommonResult.success(CommonPage.restPage(cartService.selectCartList(cart, pageNum, pageSize)));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }


    /**
     * 查询Cart列表
     */
    @ApiOperation(" 查询user的Cart列表")
    @PostMapping("/selectUserCart")
    @ResponseBody
    public CommonResult selectUserCart(Integer userId) {
        try {
            return CommonResult.success(cartService.selectUserCart(userId));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过Id查询Cart
     */
    @ApiOperation("通过Id查询Cart")
    @GetMapping("/selectCartById/{shoppingCartId}")
    @ResponseBody
    public CommonResult selectCartById(@PathVariable("shoppingCartId") Long shoppingCartId) {
        try {
            return CommonResult.success(cartService.selectCartById(shoppingCartId));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 新增Cart
     */
    @ApiOperation("新增Cart")
    @PostMapping("/insertCart")
    @ResponseBody
    public CommonResult insertCart(@RequestBody Cart cart) {
        try {
            return CommonResult.success(cartService.insertCart(cart));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 修改Cart信息
     */
    @ApiOperation("修改Cart信息")
    @PostMapping("/updateCart")
    @ResponseBody
    public CommonResult updateCart(@RequestBody Cart cart) {
        try {
            return CommonResult.success(cartService.updateCart(cart));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id删除Cart
     */
    @ApiOperation("通过id删除Cart")
    @PostMapping("/deleteCartById/{shoppingCartId}")
    @ResponseBody
    public CommonResult deleteCartById(@PathVariable("shoppingCartId") Long shoppingCartId) {
        try {
            return CommonResult.success(cartService.deleteCartById(shoppingCartId));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id批量删除Cart
     */
    @ApiOperation("通过id批量删除Cart")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCartByIds(String shoppingCartIds) {
        try {
            return CommonResult.success(cartService.deleteCartByIds(shoppingCartIds));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }
}

