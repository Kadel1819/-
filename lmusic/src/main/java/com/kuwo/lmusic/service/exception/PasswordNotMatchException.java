package com.kuwo.lmusic.service.exception;
/**
 *密码错误异常
 * @author 李钦鹏
 *
 */
public class PasswordNotMatchException extends ServiceException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8287901776834032119L;

	public PasswordNotMatchException() {
		super();
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotMatchException(String message) {
		super(message);
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
	}
}
