package com.it.emall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.it.emall.mapper") // 扫描Mapper接口
public class EmallAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallAdminApiApplication.class, args);
    }

}
