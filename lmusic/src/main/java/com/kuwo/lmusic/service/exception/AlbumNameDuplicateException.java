package com.kuwo.lmusic.service.exception;
/**
 * 专辑已存在数据异常
 * @author 李钦鹏
 *
 */
public class AlbumNameDuplicateException extends ServiceException {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5252737903221977266L;

	public AlbumNameDuplicateException() {
		super();
	}

	public AlbumNameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AlbumNameDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlbumNameDuplicateException(String message) {
		super(message);
	}

	public AlbumNameDuplicateException(Throwable cause) {
		super(cause);
	}
}
