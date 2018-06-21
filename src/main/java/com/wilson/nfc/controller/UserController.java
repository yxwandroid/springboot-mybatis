package com.wilson.nfc.controller;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangxuewu on 2018/6/19.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ServerResponse<User> login(  String userName, String password) {
        ServerResponse<User> Response = userService.login(userName, password);
        return Response;
    }

    @ApiOperation(value = "根据id获取用户信息")
    @RequestMapping(value = "id", method = RequestMethod.GET)
    public ServerResponse<User> findUserById( @RequestParam(value = "id", defaultValue = "1") Integer id) {
        ServerResponse<User> Response = userService.findUserById(id);
        return Response;
    }
}
