package com.wilson.nfc;

import com.wilson.nfc.mapper.UserMapper;
import com.wilson.nfc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangxuewu on 2018/6/21.
 * mapper 单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

  //  @Test
    public void testMapper() {

        User user = userMapper.selectByPrimaryKey(1);
        log.info("name:------------" + user.getUsername());
    }
}
