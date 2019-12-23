package com.kuwo.lmusic.service;


import org.junit.Test;
/**
 * 歌手业务测试
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.Album;
import com.kuwo.lmusic.service.exception.ServiceException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumServiceTests {
	@Autowired
	private IAlbumService service;
	@Test
	public void addSinger() {
		try {
		Album album=new Album();
		album.setName("sdafsdf");
		album.setAvatar("SDf");;
		service.addAlbum(album, "邓紫棋");
		}catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
}
