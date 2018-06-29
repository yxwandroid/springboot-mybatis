package com.wilson.nfc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.mapper.ProductMapper;
import com.wilson.nfc.model.Product;
import com.wilson.nfc.service.ProductService;
import com.wilson.nfc.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yangxuewu on 2018/6/20.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo getProdugtList(Integer categoryId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//page：当前页 rows:每页显示多少条
        List<Product> productList = productMapper.selectByCategoryId(categoryId);
        PageInfo<Product> pageInfo = new PageInfo(productList);
        //long total = pageInfo.getTotal();//total：总条数
        return pageInfo;
    }

    @Override
    public ServerResponse singleFileUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return ServerResponse.createByErrorMessage("请选择上传的图片");
        }
        String srcFileName = file.getOriginalFilename();
        String fileExtensionName = srcFileName.substring(srcFileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;

        String filePath = PropertiesUtil.getProperty("filePath", "/filePath/");

        //判断文件夹是否存在
        File files = new File(filePath);
        if (!files.exists()) {
            files.mkdirs();
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath + uploadFileName);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map fileMap = Maps.newHashMap();
        fileMap.put("uri", srcFileName);
        fileMap.put("url", uploadFileName);
        return ServerResponse.createBySuccess(fileMap);
    }


    @Override
    public ServerResponse<Product> addProduct(Product product) {
        int i = productMapper.selectProductByName(product.getName());
        if (i != 0) {
           return ServerResponse.createByErrorMessage("商品已存在");
        }
        int insert = productMapper.insert(product);
        if (insert == 0) {
            return ServerResponse.createByErrorMessage("插入失败");
        }
        return ServerResponse.createBySuccessMessage("插入成功");
    }

    @Override
    public ServerResponse<Product> updateProduct(Product product) {

        int i = productMapper.selectProductById(product.getId());
        if (i == 0) {
            return ServerResponse.createByErrorMessage("商品不存在");
        }
        //TODO 更新指定的字段
        int i1 = productMapper.updateByPrimaryKeySelective(product);
        if (i1 == 0) {
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<Product> deleteProduct(Integer productId) {
        int i = productMapper.selectProductById(productId);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("商品不存在");
        }
        int i1 = productMapper.deleteByPrimaryKey(productId);
        if (i1 == 0) {
            ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<Product> selectProductById(Integer productId) {
        Product product = productMapper.selectProduct(productId);
        if (product == null) {
            return ServerResponse.createByErrorMessage("商品不存在");
        }

        return ServerResponse.createBySuccess(product);
    }
}
