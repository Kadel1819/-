package com.kuwo.lmusic.service;


import org.junit.Test;
/**
 * 歌手业务测试
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.Singer;
import com.kuwo.lmusic.service.exception.ServiceException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SingerServiceTests {
	@Autowired
	private ISingerService service;
	@Test
	public void addSinger() {
		try {
		Singer singer=new Singer();
		singer.setName("张三");
		singer.setAge(14);
		singer.setAvatar("afgdas");
		singer.setNationality("中国");
		singer.setIsDelete(0);
		service.addSinger(singer);
		}catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
}
