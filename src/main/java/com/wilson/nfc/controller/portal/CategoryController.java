package com.wilson.nfc.controller.portal;

import com.github.pagehelper.PageInfo;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.Category;
import com.wilson.nfc.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
@RequestMapping("/category/")
public class CategoryController {
    private static Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;


    @ApiOperation(value = "添加分类")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<Category> add(@RequestBody Category category) {
        ServerResponse<Category> response = categoryService.addCategory(category);
        return response;
    }


    @ApiOperation(value = "更新分类")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<Category> update(@RequestBody Category category) {
        ServerResponse<Category> response = categoryService.updataCategory(category);
        return response;
    }

    @ApiOperation(value = "删除分类")
    @RequestMapping(value = "delete/{categoryId}", method = RequestMethod.POST)
    public ServerResponse<Category> delete(@PathVariable Integer categoryId) {
        ServerResponse<Category> response = categoryService.deleteCategory(categoryId);
        return response;
    }

    @ApiOperation(value = "select")
    @RequestMapping(value = "select/{categoryId}", method = RequestMethod.POST)
    public ServerResponse<Category> select(@PathVariable Integer categoryId) {
        ServerResponse<Category> response = categoryService.selectCategory(categoryId);
        return response;
    }

    @ApiOperation(value = "selectAll")
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public PageInfo select(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo produgtList = categoryService.getProdugtList(pageNum, pageSize);
        return produgtList;
    }

}
