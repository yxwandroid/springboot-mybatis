package com.wilson.nfc.service;


import com.github.pagehelper.PageInfo;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.Category;

/**
 * Created by yangxuewu on 2018/6/20.
 */
public interface CategoryService {

    //    crud
    ServerResponse<Category> addCategory(Category category);

    ServerResponse<Category> updataCategory(Category category);

    ServerResponse<Category> selectCategory(Integer categoryId);

    ServerResponse<Category> deleteCategory(Integer categoryId);

    PageInfo getProdugtList(Integer page, Integer rows);
}
