package com.kuwo.lmusic.service.exception;
/**
 * 插入数据异常
 * @author 李钦鹏
 *
 */
public class SingerNotFoundException extends ServiceException {


	private static final long serialVersionUID = 1128912062471681L;

	public SingerNotFoundException() {
		super();
	}

	public SingerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SingerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SingerNotFoundException(String message) {
		super(message);
	}

	public SingerNotFoundException(Throwable cause) {
		super(cause);
	}
}
