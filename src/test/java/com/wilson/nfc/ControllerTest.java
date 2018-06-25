package com.wilson.nfc;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.controller.portal.UserController;
import com.wilson.nfc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by yangxuewu on 2018/6/21.
 * controller 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
//启动类
@SpringBootTest(classes = NfcJavaApplication.class)
//web项目支持
@WebAppConfiguration
@Slf4j
public class ControllerTest {

    @Autowired
    UserController userController;

   // @Test
    public void testUserId() {
        ServerResponse<User> response = userController.findUserById(1);
        log.info(response.getData().getUsername());
    }


  //  @Test
    public void testegieter() {
        User user1 = new User();
        user1.setUsername("wilson");
        user1.setPassword("wilson");
        user1.setPhone("18515318685");
        ServerResponse<User> response = userController.register(user1);
        log.info(response.getMsg());
    }



}
