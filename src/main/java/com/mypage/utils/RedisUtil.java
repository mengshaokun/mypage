package com.mypage.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by MSK on 2019/6/7.
 */
@Component("RedisUtil")
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public boolean setObj(String key, Object value) {
        return set(redisTemplate.opsForValue(), key, value);
    }

    public boolean setStr(String key, String value) {
        return set(stringRedisTemplate.opsForValue(), key, value);
    }

    public Object getStr(String key) {
        return get(stringRedisTemplate.opsForValue(), key);
    }

    public void strSetExpireSeconds(String key, long timeout) {
        strSetExpire(key, timeout, TimeUnit.SECONDS);
    }

    public void strSetExpire(String key, long timeout, TimeUnit unit) {
        stringRedisTemplate.expire(key, timeout, unit);
    }

    public void delStr(String key) {
        stringRedisTemplate.delete(key);
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

    private Object get(ValueOperations valueOperations, String key) {
        return valueOperations.get(key);
    }

}
