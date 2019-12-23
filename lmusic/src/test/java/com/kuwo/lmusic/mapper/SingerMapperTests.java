package com.kuwo.lmusic.mapper;
import org.junit.Test;
/**
 * 用户持久层测试类
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.Singer;

/**
 * 歌手测试类
 * @author 李钦鹏
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingerMapperTests {
	@Autowired
	private SingerMapper mapper;
	
	/**
	 * 查询当前用户的数据
	 * @param username 用户名
	 * @return 用户数据
	 */
	@Test
	public void finyDataByUsername() {
		Singer singer=new Singer();
		singer.setName("张三");
		singer.setAge(14);
		singer.setAvatar("afgdas");
		singer.setNationality("中国");
		singer.setIsDelete(0);
		Integer rows=mapper.insertSinger(singer);
		System.err.println(rows);
	}
	@Test
	public void findByName() {
		Singer rows=mapper.findByName("崔伟立");
		System.err.println(rows);
	}


}
