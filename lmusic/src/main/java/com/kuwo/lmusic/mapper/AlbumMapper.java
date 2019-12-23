package com.kuwo.lmusic.mapper;

import org.apache.ibatis.annotations.Param;

import com.kuwo.lmusic.entity.Album;

/**
 * 处理专辑数据增查删改的持久层接口
 * @author 李钦鹏
 *
 */
public interface AlbumMapper {
	/**
	 * 添加专辑
	 * @param album 专辑的数据
	 * @return	执行的行数
	 */
	Integer insertAlbum(Album album);
	/**
	 * 根据专辑名和歌手id查询专辑数据
	 * @param name 专辑名
	 * @param sid	歌手id
	 * @return	专辑实体类数据
	 */
	Album findByNameAndSid(@Param("name")String name,@Param("sid")Integer sid);
}


