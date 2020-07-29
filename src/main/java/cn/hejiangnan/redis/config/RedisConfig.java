package cn.hejiangnan.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @ClassName: RedisConfig
 * @Description: Redis配置类
 * @Author: hejiangnan
 * @Date: 2020/7/20
 */
@Configuration
public class RedisConfig {

    /**
     * redisTemplate: 自定义RedisTemplate key-value 序列化策略
     *  StringRedisTemplate默认采用的是String的序列化策略（StringRedisSerializer）保存的key和value。
     *  RedisTemplate默认采用的是JDK的序列化策略（JdkSerializationRedisSerializer）保存的key和value。
     *
     *  RedisSerializer
     *  1）JdkSerializationRedisSerializer：JDK提供的序列化功能。优点是反序列化时不需要提供类型信息(class)，
     *      但缺点是需要实现Serializable接口，还有序列化后的结果非常庞大，是JSON格式的5倍左右，这样就会消耗redis服务器的大量内存
     *  2）StringRedisSerializer：String的序列化策略
     *  3）GenericToStringSerializer：String的序列化策略
     *  4）Jackson2JsonRedisSerializer：JSON格式的序列化策略
     *  5）GenericJackson2JsonRedisSerializer：JSON格式的序列化策略，会在json中加入@class属性，类的全路径包名，方便反系列化
     *  6）OxmSerializer：Xml格式的序列化策略
     *  7）ByteArrayRedisSerializer：Byte数组
     * @param connectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.io.Serializable>
     * @author hejiangnan
     * @date 2020/7/29
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        // lettuce连接池
        redisTemplate.setConnectionFactory(connectionFactory);
        // key采用String的序列化策略（StringRedisSerializer）
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // value采用Jackson的序列化策略（GenericJackson2JsonRedisSerializer）
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
