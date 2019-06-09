package com.mypage;

import com.mypage.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MypageApplicationTests {

	@Autowired
	private RedisUtil redisUtil;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedisSet() {
		boolean set = redisUtil.setStr("name", "mengsk");
		System.out.println(set);
	}
}
