package com.kuwo.lmusic.service.implement;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuwo.lmusic.entity.Singer;
import com.kuwo.lmusic.entity.Song;
import com.kuwo.lmusic.mapper.SingerMapper;
import com.kuwo.lmusic.mapper.SongMapper;
import com.kuwo.lmusic.service.ISongService;
import com.kuwo.lmusic.service.exception.SingerNotFoundException;



/**
 * 处理歌曲的业务层
 * @author 李钦鹏
 *
 */
@Service//业务层类一定要加的业务注解
public class SongServiceTmpl implements ISongService{
	
	@Autowired
	private SongMapper mapper;
	@Autowired
	private SingerMapper singerMapper;

	@Override
	public void addSong(Song song, String name) {
		//先判断歌手是否存在
		Singer singer=singerMapper.findByName(name);
		if(singer==null) {
			throw new SingerNotFoundException("歌手不存在,请先创建歌手");
		}
		//然后判断该歌手歌曲是否存在
		Song result=findByName(song.getMusicName(), singer.getSid());
		/*if() {
			
		}*/
	}
	/**
	 * 添加歌曲
	 * @param song 歌曲数据
	 * @return 执行条数
	 */
	private Integer insertSong(Song song) {
		return mapper.insertSong(song);
	}
	/**
	 * 查询这首歌歌手是否已经上传
	 * @param songName 歌曲名
	 * @param sid	歌手id
	 * @return
	 */
	private Song findByName(String songName,Integer sid) {
		return mapper.findByName(songName, sid);
	}

}
