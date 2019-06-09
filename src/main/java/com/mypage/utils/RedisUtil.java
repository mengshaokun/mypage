package com.mypage.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by MSK on 2019/6/7.
 */
@Component("RedisUtil")
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean setObj(String key, Object value) {
        return set(redisTemplate.opsForValue(), key, value);
    }

    public boolean setStr(String key, String value) {
        return set(stringRedisTemplate.opsForValue(), key, value);
    }

    private boolean set(ValueOperations valueOperations, String key, Object value) {
        try {
            valueOperations.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
