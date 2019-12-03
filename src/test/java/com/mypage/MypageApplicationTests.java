package com.mypage;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.mypage.entity.DemoData;
import com.mypage.listener.DemoDataListener;
import com.mypage.utils.RedisUtil;
import com.mypage.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		Object name = redisUtil.getStr("name");
		System.out.println(name);
		redisUtil.strSetExpireSeconds("name", 60L);
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

	@Test
	public void testLock() {

	}

	@Test
	public void testEasyExcelRead() {
		String fileName = "E:/msk/user.xlsx";
//		EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

		ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
		ReadSheet readSheet = EasyExcel.readSheet(0).headRowNumber(1).build();
		excelReader.read(readSheet);

		excelReader.finish();
	}

	@Test
	public void testEasyEasyWrite() {
		String fileName = "E:/msk/userWrite.xlsx";
		EasyExcel.write(fileName, DemoData.class).sheet().doWrite(data());

		ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
		WriteSheet writeSheet1 = EasyExcel.writerSheet(0,"模板1").build();
		WriteSheet writeSheet2 = EasyExcel.writerSheet(1,"模板2").build();
		excelWriter.write(data(), writeSheet1);
		excelWriter.write(data(), writeSheet2);

		excelWriter.finish();

	}

	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<DemoData>();
		for (int i = 0; i < 10; i++) {
			DemoData demoData = new DemoData();
			demoData.setName("张三-" + i);
			demoData.setAge(2*i);
			demoData.setAchievement(12.5D*i);
			demoData.setDate(new Date());
			list.add(demoData);
		}
		return list;
	}


























}
