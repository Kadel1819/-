package com.kuwo.lmusic.service;


import com.kuwo.lmusic.entity.User;

/**
 * 处理用户信息的业务层抽象父类
 * @author 李钦鹏
 *
 */
public interface IUserService {
	
	/**
	 * 判断用户名是否被占用
	 * @param username 传进去的参数
	 */
	void usernameDuplicate(String username);
	/**
	 * 用户注册
	 * @param user 新用户的信息
	 */
	void reg(User user);
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	User login(String username,String password);
	/**
	 * 修改用户密码
	 * @param username 用户名
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @param code 验证码
	 */
	void changePassword(String username,String oldPassword,String newPassword,String code);
	/**
	 * 更换用户头像
	 * @param uid
	 * @param avatar
	 */
	void updateByuid(Integer uid,String avatar);
}
