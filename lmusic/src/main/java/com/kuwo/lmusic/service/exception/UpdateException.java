package com.kuwo.lmusic.service.exception;
/**
 * 插入数据异常
 * @author 李钦鹏
 *
 */
public class UpdateException extends ServiceException {


	private static final long serialVersionUID = 1128912062471681L;

	public UpdateException() {
		super();
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(String message) {
		super(message);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}
}
