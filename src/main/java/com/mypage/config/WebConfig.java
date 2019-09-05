package com.mypage.config;

import com.mypage.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by mengsk on 2019/7/2.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    private LoginInterceptor loginInterceptor;

    private static List<String> pathPatternsList;

//    static {
//        pathPatternsList.add("/personal/**");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/personal/**")
                .addPathPatterns("/base/personal/checkNickNameIsExist");

    }

    /**
     * 设置默认访问路径
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/main/toMain");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
