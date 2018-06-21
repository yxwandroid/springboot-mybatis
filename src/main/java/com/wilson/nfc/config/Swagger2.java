package com.wilson.nfc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//通过@Configuration注解，让Spring来加载该类配置
@Configuration
//@EnableSwagger2注解来启用Swagger2。
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.wilson.nfc.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("nfc API ")
                .build();
//                .description("闻道有先后，术业有专攻。")
//                .termsOfServiceUrl("http://blog.csdn.net/qq_27093465?viewmode=contents")
//                .contact(new Contact("csdn大师兄", "http://blog.csdn.net/qq_27093465", "cmshome@163.com"))
//                .license("")
//                .licenseUrl("")
//                .version("1.0.0")

    }
}