springboot 配置mysql
* 在pom dependencies目录下添加 

    <!-- MYSQL -->
    		<dependency>
    			<groupId>mysql</groupId>
    			<artifactId>mysql-connector-java</artifactId>
    		</dependency>
    		
* 配置application.properties文件


        spring.datasource.url=jdbc:mysql://localhost:3306/nfc_database?useUnicode=true&characterEncoding=utf8&useSSL=true
        spring.datasource.username=root
        spring.datasource.password=8686886
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver





springboot 配置mybatis

首先先看一下项目结构

![](http://p83p6si92.bkt.clouddn.com/2018-06-20-15294842194122.jpg)



    
    com.wilson.nfc.controller - Controller 层
    com.wilson.nfc.mapper - 数据操作层 DAO
    com.wilson.nfc.model - 实体类
    com.wilson.nfc.service - 业务逻辑层
    NfcApplication - 应用启动类
    application.properties - 应用配置文件，应用启动会自动读取配置



步骤
1.    pom添加mybatis依赖
    
    <!--mybatis-->
    		<dependency>
    			<groupId>org.mybatis.spring.boot</groupId>
    			<artifactId>mybatis-spring-boot-starter</artifactId>
    			<version>1.2.0</version>
    		</dependency>

		
2.在 application.properties 应用配置文件，增加 Mybatis 相关配置

    
    ##mybatis
    mybatis.typeAliasesPackage=com.wilson.nfc.model
    mybatis.mapperLocations=classpath:mapper/*.xml
        
    mybatis.typeAliasesPackage 指向实体包路径
    mybatis.mapperLocations 配置为 classpath 路径下 mapper 包下，* 代表会扫描所有 xml 文件。
    
3.   在 Application 应用启动类添加注解 MapperScan

         @MapperScan({"com.wilson.nfc.mapper"})  
         
![](http://p83p6si92.bkt.clouddn.com/2018-06-20-15294846381848.jpg)
MapperScan ：用这个注解可以注册 Mybatis mapper 接口类。
      
4.参考

https://www.bysocket.com/?p=1610   




springboot配置mybatis.generator 

1. 在build的plugin节点下配置

        <plugin>
        		<groupId>org.mybatis.generator</groupId>
        		<artifactId>mybatis-generator-maven-plugin</artifactId>
        		<version>1.3.2</version>
        				<dependencies>
        					<dependency>
        						<groupId>mysql</groupId>
        						<artifactId>mysql-connector-java</artifactId>
        						<version>5.1.22</version>
        					</dependency>
        				</dependencies>
        				<configuration>
        					<verbose>true</verbose>
        					<overwrite>true</overwrite>
        				</configuration>
        	</plugin>
![](http://p83p6si92.bkt.clouddn.com/2018-06-20-15294859612000.jpg)



2. 在resoures资源文件下创建generatorConfig.xml文件 并编写内容

        
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE generatorConfiguration
                PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
                "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
        
        <generatorConfiguration>
        
        
            <context id="mysqlgenerator" targetRuntime="MyBatis3">
        
                <!--配置数据库-->
                <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/nfc_database"
                userId="root"
                password="8686886" />
        
                <!--配置model生成的位置-->
                <javaModelGenerator targetPackage="com.wilson.nfc.model" targetProject="src/main/java"/>
                <!--配置xml生成的位置-->
                <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources"/>
                <!--配置mapper生成的位置-->
                <javaClientGenerator type="XMLMAPPER" targetPackage="com.wilson.nfc.mapper" targetProject="src/main/java"/>
        
        
                <!--配置需要生成的表-->
                <table tableName="nfc_user" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>
                <table tableName="nfc_shipping" domainObjectName="Shipping" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>
                <!--<table tableName="nfc_product" domainObjectName="Product" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
                <!--<table tableName="nfc_pay_info" domainObjectName="PayInfo" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
                <!--<table tableName="nfc_order_item" domainObjectName="OrderItem" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
                <!--<table tableName="nfc_order" domainObjectName="Order" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
                <!--<table tableName="nfc_category" domainObjectName="Category" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
                <!--<table tableName="nfc_cart" domainObjectName="Cart" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
        
                <!--<table tableName="nfc_user"/>-->
                <!--<table tableName="city" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>-->
        
            </context>
    
    </generatorConfiguration>

3. 在maven工具类进行运行进行生成

![](http://p83p6si92.bkt.clouddn.com/2018-06-20-15294861472184.jpg)



