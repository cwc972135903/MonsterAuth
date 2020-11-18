package com.bzhi2.monster;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bzhi2.monster.**.dao")
public class MonsterApplication {
    private static Logger logger = LoggerFactory.getLogger(MonsterApplication.class);

    public static void main(String[] args) {
        logger.info("MonsterApplication项目启动......");
        SpringApplication.run(MonsterApplication.class, args);
    }

}
