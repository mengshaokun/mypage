package com.mypage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 * Created by MSK on 2020/6/6.
 * 设置项目启动后打开浏览器主页
 */
@Configuration
@Slf4j
public class IndexConfig {

    private static final String URL = "http://localhost:8080/main";

    @EventListener(ApplicationReadyEvent.class)
    void applicationReadyEvent() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + URL);
        } catch (IOException e) {
            log.info("项目启动打开浏览器失败！");
        }
    }
}
