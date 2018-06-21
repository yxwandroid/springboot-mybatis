package com.wilson.nfc.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 注册MyBatis分页插件PageHelper
 * Created by CatalpaFlat on 2017/8/28.
 */
@Configuration
public class MyBatisPagConfig {
    private Logger logger = LoggerFactory.getLogger(MyBatisPagConfig.class);
    @Bean
    public PageHelper pageHelper() {
        logger.info("加载：MyBatis分页插件PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
