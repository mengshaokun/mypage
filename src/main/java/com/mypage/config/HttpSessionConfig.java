package com.mypage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by mengsk on 2019/6/10.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*30)
public class HttpSessionConfig {
}
