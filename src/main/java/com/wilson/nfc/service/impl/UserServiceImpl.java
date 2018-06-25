package com.wilson.nfc.service.impl;

import com.wilson.nfc.common.Const;
import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import com.wilson.nfc.util.MD5Util;
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
    public ServerResponse<User> login(User user) {
        int resultName = userMapper.checkUserName(user.getUsername());
        if (resultName==0){
            return  ServerResponse.createByErrorMessage("用户名不存在");
        }
        String newPassward = MD5Util.MD5EncodeUtf8(user.getPassword());
        User user1 = userMapper.selectLogin(user.getUsername(), newPassward);

        if (user1==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user1.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return  ServerResponse.createBySuccess("登录成功", user1);
    }

    @Override
    public ServerResponse<User> regieter(User user) {
        //校验用户是否已经存在
        int resultId = userMapper.checkUserName(user.getUsername());
        if (resultId !=0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }

        user.setRole(Const.Role.ROLE_CUSTOMER); //设置用户角色
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int resultCount = userMapper.insert(user);
        if (resultCount==0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("注册成功", user);

    }

    @Override
    public ServerResponse<User> addUser(User user) {
        ServerResponse<User> regieter = regieter(user);
        return regieter;
    }

    @Override
    public ServerResponse<User> deleteUser(Integer userId) {
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i==0){
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<User> updateUser(User user) {
        // 用户是否存在校验
        //
        int i = userMapper.updateByPrimaryKey(user);
        if (i==0){
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }
}
