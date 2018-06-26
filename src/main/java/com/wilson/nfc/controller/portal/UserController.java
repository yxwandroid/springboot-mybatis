package com.wilson.nfc.controller.portal;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yangxuewu on 2018/6/19.
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @ApiOperation(value = "注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ServerResponse<User> register(@RequestBody User user) {
        ServerResponse<User> response = userService.regieter(user);
        return response;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ServerResponse<User> login(@RequestBody User user) {
        ServerResponse<User> response = userService.login(user);
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        log.info(user.toString());
        return response;
    }




    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<User> updateUser(@RequestBody User user) {
        ServerResponse<User> response = userService.updateUser(user);
        return response;
    }


    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ServerResponse<User> delete(@PathVariable(value="id")Integer id) {
        ServerResponse<User> response = userService.deleteUser(id);
        return response;
    }



    @ApiOperation(value = "根据id获取用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ServerResponse<User> findUserById( @PathVariable(value = "id") Integer id) {
        ServerResponse<User> response = userService.findUserById(id);
        return response;
    }


}
