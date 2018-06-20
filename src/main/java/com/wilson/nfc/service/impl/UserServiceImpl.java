package com.wilson.nfc.service.impl;

import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangxuewu on 2018/6/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
