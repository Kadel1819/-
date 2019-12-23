package com.kuwo.lmusic.mapper;
import org.junit.Test;
/**
 * 用户持久层测试类
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.Album;
/**
 * 持久层专辑测试类
 * @author 李钦鹏
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumMapperTests {
	@Autowired
	private AlbumMapper mapper;
	
	/**
	 * 查询当前用户的数据
	 * @param username 用户名
	 * @return 用户数据
	 */
	@Test
	public void insertAlbum() {
		Album album=new Album();
		album.setSid(3);
		album.setName("Adsaf");
		album.setAvatar("ddsfads");
		album.setIsDelete(0);
		Integer rows=mapper.insertAlbum(album);
		System.err.println(rows);
	}
	@Test
	public void findByNameAndSid() {
		Album album=mapper.findByNameAndSid("Adsaf", 3);
		System.err.println(album);
	}


}
