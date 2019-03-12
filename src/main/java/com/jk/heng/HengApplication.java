package com.jk.heng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HengApplication {

    public static void main(String[] args) {
        SpringApplication.run(HengApplication.class, args);
    }

}
