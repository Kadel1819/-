package com.kuwo.lmusic.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kuwo.lmusic.controller.ex.FileEmptyException;
import com.kuwo.lmusic.controller.ex.FileIOException;
import com.kuwo.lmusic.controller.ex.FileSizeException;
import com.kuwo.lmusic.controller.ex.FileStateException;
import com.kuwo.lmusic.controller.ex.FileTypeException;
import com.kuwo.lmusic.entity.User;
import com.kuwo.lmusic.service.IUserService;
import com.kuwo.lmusic.util.JsonResult;

@RequestMapping("users")
@RestController
public class UserController extends BaseController{
	@Autowired
	private IUserService iUserService;
	/**
	 * 判断用户名是否重复
	 * @param username
	 * @return
	 */
	@PostMapping("th")
	public JsonResult<Void>usernameJudge(String username){
		iUserService.usernameDuplicate(username);
		return new JsonResult<Void>(OK);
	}
	/**
	 * 用户注册
	 * @param username
	 * @return
	 */
	@PostMapping("reg")
	public JsonResult<Void>reg(User user){
		//调用业务类的reg()方法实现注册
		iUserService.reg(user);
		//返回
		return new JsonResult<>(OK);
	}
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@PostMapping("login")
	public JsonResult<User>login(String username,String password, HttpSession session){
		User user = iUserService.login(username, password);
		//将登录的数据保存在session中
		session.setAttribute("uid",user.getUid());
		session.setAttribute("username", user.getUsername());
		System.err.println("用户登录成功");
		//返回
		return new JsonResult<User>(OK);
	}
	@PostMapping("change_password")
	public JsonResult<Void>changePassword(String oldPassword,String newPassword, HttpSession session){
		String username=getUsernameFromSession(session);
		iUserService.changePassword(username, oldPassword, newPassword, null);
		//返回
		return new JsonResult<Void>(OK);
	}
	/**
	 * 退出登录
	 * @return
	 */
	@GetMapping("exit")
	public JsonResult<Void> exit(HttpSession session){
		session.removeAttribute("uid");
		session.removeAttribute("username");
		return new JsonResult<Void>(OK);
	}
	//获取配置文件里面属性的值
	@Value("${project.upload.avatar.max-size}")
	private int MaxFile;
	//允许上传的文件类型
	//允许上传的文件类型
	private static final List<String> AVATART_TYPES = new ArrayList<>();
	static {
		AVATART_TYPES.add("image/jpeg");
		AVATART_TYPES.add("image/png");
	}
	@PostMapping("change_avatar")
	public JsonResult<String>changePassword(@PathParam("file")MultipartFile file,HttpSession session){
		//获取当前登录的用户id
		Integer uid=getUidFromSession(session);
		
		//判断上传文件是否为null
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
		File dir=new File(session.getServletContext().getRealPath("UserAvatar"));
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
		String avatar = "/UserAvatar/" + filename;
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
		iUserService.updateByuid(uid, avatar);
		//返回
		return new JsonResult<>(OK,avatar);
	}
}
