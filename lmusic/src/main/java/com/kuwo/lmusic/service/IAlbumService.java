package com.kuwo.lmusic.service;

import com.kuwo.lmusic.entity.Album;

/**
 * 处理专辑的业务层抽象父类
 * @author 李钦鹏
 *
 */
public interface IAlbumService {
	/**
	 * 添加专辑
	 * @param album 专辑数据
	 * @param name	歌手name
	 */
	void addAlbum(Album album,String name);
}
