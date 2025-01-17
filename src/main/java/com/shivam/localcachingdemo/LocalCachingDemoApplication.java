package com.shivam.localcachingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LocalCachingDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalCachingDemoApplication.class, args);
    }
}
