package com.wilson.nfc;

import com.wilson.nfc.common.ServerResponse;
import com.wilson.nfc.model.User;
import com.wilson.nfc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangxuewu on 2018/6/21.
 * service单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceTest {

    @Autowired
    private UserService userService;

    //@Test
    public void testService() {
        ServerResponse<User> user = userService.findUserById(1);
        log.info("ServiceTest" + "-----" + user.getData().getUsername());
    }

   // @Test
    public void testRegieter() {
        User user1 = new User();
        user1.setUsername("wilson");
        user1.setPassword("wilson");
        user1.setPhone("18515318685");
        ServerResponse<User> user = userService.regieter(user1);
        log.info("ServiceTest" + "-----" + user.getMsg());
    }
}
