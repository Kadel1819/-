package com.kuwo.lmusic.controller;


import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kuwo.lmusic.controller.ex.FileEmptyException;
import com.kuwo.lmusic.controller.ex.FileException;
import com.kuwo.lmusic.controller.ex.FileIOException;
import com.kuwo.lmusic.controller.ex.FileSizeException;
import com.kuwo.lmusic.controller.ex.FileStateException;
import com.kuwo.lmusic.controller.ex.FileTypeException;
import com.kuwo.lmusic.service.exception.AlbumNameDuplicateException;
import com.kuwo.lmusic.service.exception.ExitException;
import com.kuwo.lmusic.service.exception.InsertException;
import com.kuwo.lmusic.service.exception.PasswordNotMatchException;
import com.kuwo.lmusic.service.exception.ServiceException;
import com.kuwo.lmusic.service.exception.UpdateException;
import com.kuwo.lmusic.service.exception.UserNotFoundException;
import com.kuwo.lmusic.service.exception.UsernameDuplicateException;
import com.kuwo.lmusic.util.JsonResult;

/**
 * 控制器类的基类
 */
public abstract class BaseController {
	///操作成功时的状态码
	public static final int OK = 2000;
	
	/**
	 * 从Session中获取当前登录的用户的id
	 * @param session HttpSession对象
	 * @return 登录的用户的id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
		
	}
	protected final String getUsernameFromSession(HttpSession session) {
		return String.valueOf(session.getAttribute("username"));
	}
	
	
	
	@ExceptionHandler({ServiceException.class,FileException.class})
	public JsonResult<Void> handleException(Throwable e){
		JsonResult<Void> jr = new JsonResult<Void>(e);/**将异常对象传进去到时候在获取异常的参数*/
		
		if(e instanceof UsernameDuplicateException) {
			jr.setState(4000);
		}else if(e instanceof InsertException) {
			jr.setState(4001);
		}else if(e instanceof UserNotFoundException) {
			jr.setState(6001);
		}else if(e instanceof PasswordNotMatchException) {
			jr.setState(6002);
		}else if(e instanceof UpdateException) {
			jr.setState(4002);
		}else if(e instanceof ExitException) {
			jr.setState(6600);
		}else if(e instanceof FileIOException) {
			jr.setState(3001);
		}else if(e instanceof FileSizeException) {
			jr.setState(3002);
		}else if(e instanceof FileStateException) {
			jr.setState(3003);
		}else if(e instanceof FileTypeException) {
			jr.setState(3004);
		}else if(e instanceof FileEmptyException) {
			jr.setState(3005);
		}else if(e instanceof AlbumNameDuplicateException) {
			jr.setState(4003);
		}
		return jr;
	}
}
