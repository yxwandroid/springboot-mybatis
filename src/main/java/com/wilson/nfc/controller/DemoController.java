package com.wilson.nfc.controller;

import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangxuewu on 2018/6/19.
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
public class DemoController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    public String apiHello() {

        User user = userMapper.selectByPrimaryKey(1);
        System.out.print(user.getUsername().toString());
        return "wilson hello";
    }
}
