package com.mypage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mypage.dao"})
public class MypageApplication{

	public static void main(String[] args) {
		SpringApplication.run(MypageApplication.class, args);
	}

}
