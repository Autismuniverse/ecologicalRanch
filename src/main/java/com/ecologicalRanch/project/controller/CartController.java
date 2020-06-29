package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Cart;
import com.ecologicalRanch.project.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-27 16:34:04'
 */
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
                                       @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(cartService.selectCartList(cart,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Cart
     */
    @ApiOperation("通过Id查询Cart")
    @GetMapping("/selectCartById/{shoppingCartId}")
    @ResponseBody
    public CommonResult selectCartById(@PathVariable("shoppingCartId") Long shoppingCartId){
        return CommonResult.success(cartService.selectCartById(shoppingCartId));
    }

    /**
     * 新增Cart
     */
    @ApiOperation("新增Cart")
    @PostMapping("/insertCart")
    @ResponseBody
    public CommonResult insertCart(@RequestBody Cart cart){
        return CommonResult.success(cartService.insertCart(cart));
    }

    /**
     * 修改Cart信息
     */
    @ApiOperation("修改Cart信息")
    @PostMapping("/updateCart")
    @ResponseBody
    public CommonResult updateCart(@RequestBody Cart cart){
        return CommonResult.success(cartService.updateCart(cart));
    }

    /**
     * 通过id删除Cart
     */
    @ApiOperation("通过id删除Cart")
    @PostMapping("/deleteCartById/{shoppingCartId}")
    @ResponseBody
    public CommonResult deleteCartById(@PathVariable("shoppingCartId") Long shoppingCartId){
        return CommonResult.success(cartService.deleteCartById(shoppingCartId));
    }

    /**
     * 通过id批量删除Cart
     */
    @ApiOperation("通过id批量删除Cart")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCartByIds(@RequestBody String shoppingCartIds){
        return CommonResult.success(cartService.deleteCartByIds(shoppingCartIds));
    }
}

