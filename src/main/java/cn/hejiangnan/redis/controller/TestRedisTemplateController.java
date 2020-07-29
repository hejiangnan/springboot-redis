package cn.hejiangnan.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import cn.hejiangnan.redis.entity.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TestRedisTemplateController
 * @Description: Redis RedisTemplate测试
 * @Author: hejiangnan
 * @Date: 2020/7/29
 */
@Slf4j
@RequestMapping("/redis/template")
@RestController
public class TestRedisTemplateController {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @GetMapping("/valueOperations")
    public void valueOperations() {
        // 新增数据
        String key = "User:zhangsan";
        redisTemplate.opsForValue().set(key, UserDTO.builder()
                .userCode(123)
                .userName("张三")
                .sex(true)
                .age(20)
                .birth(LocalDateTime.now())
                .build());

        // 查询数据
        UserDTO userDTO = (UserDTO) redisTemplate.opsForValue().get(key);
        log.info(userDTO != null ? userDTO.toString() : null);
    }
}
