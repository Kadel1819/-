package com.kuwo.lmusic.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 歌手控制器类
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kuwo.lmusic.controller.ex.FileEmptyException;
import com.kuwo.lmusic.controller.ex.FileIOException;
import com.kuwo.lmusic.controller.ex.FileSizeException;
import com.kuwo.lmusic.controller.ex.FileStateException;
import com.kuwo.lmusic.controller.ex.FileTypeException;
import com.kuwo.lmusic.entity.Album;
import com.kuwo.lmusic.service.IAlbumService;
import com.kuwo.lmusic.util.JsonResult;

@RequestMapping("Album")
@RestController
public class AlbumController extends BaseController{
	@Autowired
	private IAlbumService service;

	//获取配置文件里面属性的值
	@Value("${project.upload.avatar.max-size}")
	private int MaxFile;
	//允许上传的文件类型
	//允许上传的文件类型
	private static final List<String> AVATART_TYPES = new ArrayList<>();
	static {
//		AVATART_TYPES.add("audio/mpeg");
		AVATART_TYPES.add("image/jpeg");
		AVATART_TYPES.add("image/png");
	}

	@RequestMapping("add")
	public JsonResult<Void>addAlbum(@RequestParam("file")MultipartFile file,String uName,String aName,HttpSession session){
		System.err.println(uName);
		//创建业务层需要使用到的对象
		Album album=new Album();
		album.setName(aName);
		if(file.isEmpty()) {
			throw new FileEmptyException("上传文件不能为空");
		}
		//检查大小文件
		if(file.getSize()>MaxFile) {
			throw new FileSizeException("歌手头像大小超出了限制");
		}
		//检查文件类型是否正确
		if(!AVATART_TYPES.contains(file.getContentType())) {
			//getContentType是获取文件的MMID类型,然后在集合中查找是否存在该key值
			throw new FileTypeException("上传的文件类型有误,请重新选择");
		}
		//开始保存文件到服务端
		//获取上传原文件的名字
		String oldFileName=file.getOriginalFilename();
		//保存上传文件时的文件夹
		File dir=new File(session.getServletContext().getRealPath("AlbumAvatar"));
		if (!dir.exists()) {
			dir.mkdir();//如果文件夹不存在就创建文件夹
		}
		// 保存上传的头像时使用的文件名
		String fileName =System.nanoTime()+"-avatar";
		String suffix = "";
		int i = oldFileName.lastIndexOf(".");
		if (i > 0) {
			suffix = oldFileName.substring(i);
		}
		String filename = fileName + suffix;

		// 歌手头像的路径(响应给客户端的，且存入到数据库的)
		String avatar = "/AlbumAvatar/" + filename;
		System.out.println("avatar=" + avatar);
		//将文件保存在服务器中
		File reFile=new File(dir,filename);
		try {
			file.transferTo(reFile);
		} catch (IllegalStateException e) {
			throw new FileStateException("文件状态异常,可能是原文件无法访问");
		} catch (IOException e) {
			throw new FileIOException("读取文件异常,请重新上传");
		}
		//补全数据
		album.setAvatar(avatar);
		//执行业务层保存专辑数据
		service.addAlbum(album, uName);
		return new JsonResult<>(OK);
	}
}
