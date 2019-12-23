package com.kuwo.lmusic.service.implement;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuwo.lmusic.entity.Album;
import com.kuwo.lmusic.entity.Singer;
import com.kuwo.lmusic.mapper.AlbumMapper;
import com.kuwo.lmusic.mapper.SingerMapper;
import com.kuwo.lmusic.service.IAlbumService;
import com.kuwo.lmusic.service.exception.AlbumNameDuplicateException;
import com.kuwo.lmusic.service.exception.InsertException;
import com.kuwo.lmusic.service.exception.SingerNotFoundException;



/**
 * 处理歌曲的业务层
 * @author 李钦鹏
 *
 */
@Service//业务层类一定要加的业务注解
public class AlbumServiceTmpl implements IAlbumService{
	
	@Autowired
	private AlbumMapper mapper;

	@Autowired
	private SingerMapper singerMapper;
	@Override
	public void addAlbum(Album album, String name) {
		System.err.println("????"+name);
		//先查询归属歌手的id
		Singer singer=singerMapper.findByName(name);
		//判断歌手是否存在,如果存在才能创建专辑
		if(singer==null) {
			throw new SingerNotFoundException("歌手不存在,请先添加歌手");
		}
		//获取歌手对应的id和名称
		Integer sid=singer.getSid();
		String Aname=album.getName();
		Album result=findByNameAndSid(Aname, sid);
		//如果该专辑不为null,说明该专辑已经是存在了
		if(result!=null) {
			throw new AlbumNameDuplicateException("专辑已存在,请勿重复添加该专辑");
		}
		//补全数据
		album.setSid(sid);
		album.setName(album.getName());
		album.setIsDelete(0);
		album.setCreatedTime(new Date());
		album.setCreateUser("超级管理员");
		album.setModifiedTime(new Date());
		album.setModifiedUser("超级管理员");
		Integer rows=insertAlbum(album);
		if(rows!=1) {
			throw new InsertException("添加异常,请稍后在尝试");
		}
	}
	/**
	 * 添加专辑
	 * @param album 专辑的数据
	 * @return	执行的行数
	 */
	private Integer insertAlbum(Album album) {
		return mapper.insertAlbum(album);
	}
	/**
	 * 根据专辑名和歌手id查询专辑数据
	 * @param name 专辑名
	 * @param sid	歌手id
	 * @return	专辑实体类数据
	 */
	private Album findByNameAndSid(String name,Integer sid) {
		return mapper.findByNameAndSid(name, sid);
	}
}
