package com.kuwo.lmusic.util;
/**
 * 
 * 用于封装数据返回给客户端的类
 * @author 李钦鹏
 *
 */
public class JsonResult<T> {
	private Integer state;/*状态参数*/
	private String message;/*状态描述*/
	private T data;/*数据*/
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	
	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public JsonResult(Throwable e) {
		super();
		this.message=e.getMessage();/*异常的描述*/
	}

	public JsonResult() {
		super();
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
