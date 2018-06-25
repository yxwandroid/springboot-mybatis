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

    /**
     * 登录
     * @param user
     * @return
     */
    ServerResponse<User> login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    ServerResponse<User> regieter(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    ServerResponse<User> addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    ServerResponse<User> deleteUser(Integer userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    ServerResponse<User> updateUser(User user);

}
