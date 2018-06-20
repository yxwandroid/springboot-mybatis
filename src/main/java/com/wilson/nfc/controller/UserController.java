package com.wilson.nfc.controller;

import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
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

    @RequestMapping(value = "/api/user/id", method = RequestMethod.GET)
    public User findOneCity(@RequestParam(value = "id", required = true) Integer id) {
        return userService.findUserById(id);
    }
}