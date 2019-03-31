package com.jk.heng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync // 启动异步调用
public class HengApplication {

    public static void main(String[] args) {
        SpringApplication.run(HengApplication.class, args);
    }

}
