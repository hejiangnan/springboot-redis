package cn.hejiangnan.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: SpringBootRedisApplication
 * @Description: SpringBoot项目启动类
 * @Author: hejiangnan
 * @Date: 2020/7/29
 */
@MapperScan({"cn.hejiangnan.redis.mapper"})
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}
