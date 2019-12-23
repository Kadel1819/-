package com.kuwo.lmusic.service.exception;
/**
 * 找不到用户异常
 * @author 李钦鹏
 *
 */
public class UserNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6575582211260063222L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
}
