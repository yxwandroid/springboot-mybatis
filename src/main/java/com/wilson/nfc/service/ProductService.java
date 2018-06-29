package com.wilson.nfc.service;


import com.github.pagehelper.PageInfo;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.Product;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yangxuewu on 2018/6/20.
 */
public interface ProductService {


    PageInfo getProdugtList(Integer categoryId, Integer page, Integer rows);

    ServerResponse singleFileUpload(MultipartFile file);

    ServerResponse<Product> addProduct(Product product);

    ServerResponse<Product> updateProduct(Product product);

    ServerResponse<Product> deleteProduct(Integer productId);

    ServerResponse<Product> selectProductById(Integer productId);
}
