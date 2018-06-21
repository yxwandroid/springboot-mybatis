package com.wilson.nfc.service;


import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.User;

/**
 * Created by yangxuewu on 2018/6/20.
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     */
    ServerResponse<User> findUserById(Integer id);

    ServerResponse<User> login(String userName,String password);

}
