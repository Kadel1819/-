package com.kuwo.lmusic.service.implement;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuwo.lmusic.entity.Singer;
import com.kuwo.lmusic.mapper.SingerMapper;
import com.kuwo.lmusic.service.ISingerService;
import com.kuwo.lmusic.service.exception.InsertException;
import com.kuwo.lmusic.service.exception.SingerNotFoundException;



/**
 * 处理用户信息的业务类
 * @author 李钦鹏
 *
 */
@Service//业务层类一定要加的业务注解
public class SingerServiceTmpl implements ISingerService{
	
	@Autowired
	private SingerMapper mapper;
	
	@Override
	public void addSinger(Singer singer) {
		//先查询该歌手是否
		Singer result=findByName(singer.getName());
		if(result!=null) {
			throw new SingerNotFoundException("请勿添加重复的歌手");
		}
		//补全数据
		singer.setCreatedTime(new Date());
		singer.setCreateUser("超级管理员");
		singer.setModifiedTime(new Date());
		singer.setModifiedUser("超级管理员");
		singer.setIsDelete(0);//状态
		//再进行插入数据
		Integer rows=insertSinger(singer);
		if(rows!=1) {
			throw new InsertException("添加异常,请联系管理员");
		}
	}
	/**
	 * 添加歌手
	 * @param singer 歌手数据
	 * @return 执行条数
	 */
	private Integer insertSinger(Singer singer) {
		return mapper.insertSinger(singer);
	}
	/**
	 * 查询歌手是否存在
	 * @param name 歌手名
	 * @return 歌手对象
	 */
	private Singer findByName(String name) {
		return mapper.findByName(name);
	}
	
}
