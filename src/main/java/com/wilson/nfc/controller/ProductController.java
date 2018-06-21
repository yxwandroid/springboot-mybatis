package com.wilson.nfc.controller;

import com.github.pagehelper.PageInfo;
import com.wilson.nfc.model.Product;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.ProductService;
import com.wilson.nfc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "获取商品信息",notes = "根据分类id获取商量信息")
    @RequestMapping(value = "/api/categoryId", method = RequestMethod.GET)
    public PageInfo ProductList(
            @RequestParam(value = "categoryId", defaultValue = "1") Integer categoryId,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
                            ) {
        return productService.getProdugtList(categoryId,pageNum,pageSize);
    }
}
