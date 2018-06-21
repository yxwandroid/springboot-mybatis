package com.wilson.nfc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wilson.nfc.mapper.ProductMapper;
import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.Product;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.ProductService;
import com.wilson.nfc.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangxuewu on 2018/6/20.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo getProdugtList(Integer categoryId ,Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//page：当前页 rows:每页显示多少条
        List<Product> productList= productMapper.selectByCategoryId(categoryId);
        PageInfo<Product> pageInfo = new PageInfo(productList);
        //long total = pageInfo.getTotal();//total：总条数
        return pageInfo;
    }
}
