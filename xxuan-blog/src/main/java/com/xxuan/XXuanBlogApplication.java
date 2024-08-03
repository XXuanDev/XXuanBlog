package com.xxuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: XXuanBlogApplication
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-20 16:08
 * @Version: V1.0
 */

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class XXuanBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(XXuanBlogApplication.class,args);
    }
}

