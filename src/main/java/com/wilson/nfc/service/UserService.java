package com.wilson.nfc.service;


import com.wilson.nfc.model.User;

/**
 * Created by yangxuewu on 2018/6/20.
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     */
    User findUserById(Integer id);
}
