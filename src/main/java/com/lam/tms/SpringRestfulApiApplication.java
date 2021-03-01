package com.lam.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 启动类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.lam.tms.mapper")
@SpringBootApplication
public class SpringRestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestfulApiApplication.class, args);
    }

}
