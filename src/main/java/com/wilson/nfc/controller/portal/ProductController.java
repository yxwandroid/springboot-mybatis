package com.wilson.nfc.controller.portal;

import com.github.pagehelper.PageInfo;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.Product;
import com.wilson.nfc.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "添加商品")
    @PostMapping("add")
    public ServerResponse add(@RequestBody Product product) {
        return productService.addProduct(product);

    }


    @ApiOperation(value = "更新商品")
    @PostMapping("update")
    public ServerResponse update(@RequestBody Product product) {
        return productService.updateProduct(product);

    }

    @ApiOperation(value = "删除商品")
    @PostMapping("delete/{productId}")
    public ServerResponse delete(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);

    }

    @ApiOperation(value = "查询商品")
    @GetMapping("select/{productId}")
    public ServerResponse select(@PathVariable Integer productId) {
        return productService.selectProductById(productId);

    }


    @ApiOperation(value = "获取分类商品", notes = "根据分类id获取商量信息")
    @RequestMapping(value = "categoryId", method = RequestMethod.GET)
    public PageInfo ProductList(
            @RequestParam(value = "categoryId", defaultValue = "1") Integer categoryId,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return productService.getProdugtList(categoryId, pageNum, pageSize);
    }


    @ApiOperation(value = "上传图片表单形式 ")
    @PostMapping("upload")
    public ServerResponse singleFileUpload(@RequestParam(value = "file") MultipartFile file) {
        return productService.singleFileUpload(file);

    }
}
