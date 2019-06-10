package com.mypage;

import com.mypage.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MypageApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(MypageApplicationTests.class);
	@Autowired
	private RedisUtil redisUtil;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedisSet() {
		boolean set = redisUtil.setStr("name", "mengsk123");
		System.out.println(set);
	}

	@Test
    public void testLog() {
	    while (true) {
            logger.info("普通日志");
            logger.info("{}:::日志", "ceshi");
            logger.error("错误日志");
			try {
				System.out.println(1/0);
			} catch (Exception e) {
				logger.error("{}，错误信息：", "ceshi", e);
				return;
			}

		}
    }
}
