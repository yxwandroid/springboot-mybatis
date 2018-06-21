package com.wilson.nfc.controller;

import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "获取用户信息",notes = "获取登录用户信息")
    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public String getUserInfo() {

        return "userName";

    }
    @ApiOperation(value = "获取用户信息",notes = "获取登录用户信息")
    @RequestMapping(value = "/api/user/id", method = RequestMethod.GET)
    public User findOneCity(@RequestParam(value = "id", required = true) Integer id) {
        return userService.findUserById(id);
    }
}
