package com.mypage;

import com.mypage.utils.RedisUtil;
import com.mypage.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MypageApplicationTests {
//    private static final Logger logger = LoggerFactory.getLogger(MypageApplicationTests.class);
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
//	    while (true) {
//            log.info("普通日志");
//			log.info("{}:::日志", "ceshi");
//			log.error("错误日志");
////			try {
////				System.out.println(1/0);
////			} catch (Exception e) {
////				log.error("{}，错误信息：", "ceshi", e);
////				return;
////			}
//
//		}
    }

    @Test
	public void testMd5() {
		System.out.println(SignUtils.md5Encrypt("1233"));
	}

}
