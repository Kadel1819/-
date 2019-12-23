package com.kuwo.lmusic.controller.ex;
/**
 * 文件异常基类
 * @author 李钦鹏
 *
 */
public class FileException extends RuntimeException {


	private static final long serialVersionUID = 5092075181775507939L;

	public FileException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public FileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public FileException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FileException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
