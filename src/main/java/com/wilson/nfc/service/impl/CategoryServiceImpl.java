package com.wilson.nfc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.mapper.CategoryMapper;
import com.wilson.nfc.model.Category;
import com.wilson.nfc.model.Product;
import com.wilson.nfc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by yangxuewu on 2018/6/20.
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse<Category> addCategory(Category category) {
        //检查是否已存在分类
        int i = categoryMapper.selectByCategoryName(category.getName());
        if (i != 0) {
            return ServerResponse.createByErrorMessage("分类已存在");
        }
        int insert = categoryMapper.insert(category);
        if (insert==0){
            return ServerResponse.createByErrorMessage("插入分类失败");
        }
        return ServerResponse.createBySuccess(category);
    }

    @Override
    public ServerResponse<Category> updataCategory(Category category) {
        Category category1 = categoryMapper.selectByCategory(category.getName());
        if (category1 == null) {
            return ServerResponse.createByErrorMessage("分类不存在");
        }
        category1.setName(category.getName());
        category1.setStatus(category.getStatus());
        category1.setExtra1(category.getExtra1());
        category1.setExtra2(category.getExtra2());
        category1.setExtra3(category.getExtra3());
        int updateId = categoryMapper.updateByPrimaryKey(category1);
        if (updateId==0){
            return  ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<Category> selectCategory(Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category ==null){
            ServerResponse.createByErrorMessage("用户不存在");
        }
        return  ServerResponse.createBySuccess(category) ;
    }

    @Override
    public ServerResponse<Category> deleteCategory(Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category ==null){
            ServerResponse.createByErrorMessage("用户不存在");
        }
        int i = categoryMapper.deleteByPrimaryKey(categoryId);
        if (i==0){
            ServerResponse.createByErrorMessage("删除分类失败");

        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public PageInfo getProdugtList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);//page：当前页 rows:每页显示多少条
        List<Category> categories = categoryMapper.selectList();
        PageInfo<Product> pageInfo = new PageInfo(categories);
        return pageInfo;
    }
}
