package com.wilson.nfc.controller.backend;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ServerResponse<User> register(@RequestBody User user) {
        ServerResponse<User> response = userService.regieter(user);
        if (response.isSuccess()){
            return response;
        }
        return response;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ServerResponse<User> login(@RequestBody User user) {
        ServerResponse<User> response = userService.login(user);
        if (response.isSuccess()){
            return response;
        }
        return response;
    }

    @ApiOperation(value = "根据id获取用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ServerResponse<User> findUserById( @PathVariable(value = "id") Integer id) {
        ServerResponse<User> response = userService.findUserById(id);
        return response;
    }


}
