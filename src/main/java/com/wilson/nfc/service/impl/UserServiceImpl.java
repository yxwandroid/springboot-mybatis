package com.wilson.nfc.service.impl;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangxuewu on 2018/6/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<User> findUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user ==null){
            return  ServerResponse.createByErrorMessage("查询不到用户信息");
        }
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse<User> login(String userName, String password) {


        return null;
    }
}
