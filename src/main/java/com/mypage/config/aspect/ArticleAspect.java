package com.mypage.config.aspect;

import com.mypage.common.Response;
import com.mypage.entity.Article;
import com.mypage.entity.User;
import com.mypage.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by mengsk on 2019/10/14.
 */
@Aspect
@Component
@Slf4j
public class ArticleAspect {

    @Resource
    private RedisUtil redisUtil;

    @Value("${user.session.key}")
    private String userSessionKey;

    @Pointcut(value = "@annotation(com.mypage.annotation.ArticleReSubmit)")
    public void annotationPointCut() {

    }

    @Around("annotationPointCut()")
    public Object NoReSubmit(ProceedingJoinPoint joinPoint) {
//        System.out.println("spring aop +++++++++++++++++++++++++++++++");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        Object sessionUser = session.getAttribute(userSessionKey);
        if (sessionUser == null) {
            return Response.FAIL("页面超时，请重新登录");
        }
        User user = (User) sessionUser;
        Integer userId = user.getId();
//        System.out.println(userId);
        Object[] args = joinPoint.getArgs();
//        System.out.println(args);
        Article article = null;
        for (Object object : args) {
            if (object instanceof Article) {
                article = (Article) object;
            }
        }
        if (args == null) {
            return Response.FAIL("请求参数错误");
        }

        String key = userId + "_" + article.getTitle();
        Object flag = redisUtil.getStr(key);

        if (flag == null) {
            redisUtil.setStr(key, "1");
            redisUtil.strSetExpireSeconds(key, 5*60L);
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                redisUtil.delStr(key);
                return Response.FAIL("系统错误，请联系管理员！");
            }
        } else {
            log.info("{}:重复提交", key);
            return Response.FAIL("重复提交");
        }
    }
}
