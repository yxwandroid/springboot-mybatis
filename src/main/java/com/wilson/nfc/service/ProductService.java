package com.wilson.nfc.service;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by yangxuewu on 2018/6/20.
 */
public interface ProductService {


    PageInfo getProdugtList(Integer categoryId , Integer page, Integer rows);

}
