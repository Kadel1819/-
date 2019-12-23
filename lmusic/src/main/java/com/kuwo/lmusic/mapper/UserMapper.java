package com.kuwo.lmusic.mapper;

import org.apache.ibatis.annotations.Param;

import com.kuwo.lmusic.entity.User;



/**
 * 处理用户数据增查删改的持久层接口
 * @author 李钦鹏
 *
 */
public interface UserMapper {
	/**
	 * 查询当前用户的数据
	 * @param username 用户名
	 * @return 用户数据
	 */
	User finyDataByUsername(String username);
	
	/**
	 * 用户注册
	 * 插入一条用户数据
	 * @param user 用户实体数据
	 * @return 执行的行数
	 */
	Integer insertByUserData(User user);
	/**
	 * 修改用户的密码
	 * @param password 原密码 
	 * @return 执行的条数
	 */
	Integer updateByYan(@Param("user")User user,@Param("newPassword")String newPassword);
	/**
	 * 更换头像
	 * @param uid
	 * @return 执行的行数
	 */
	Integer updateAvatar(@Param("user")User user,@Param("avatar")String avatar);
	/**
	 * 根据用户的id查询用户信息
	 * @param uid 用户的id
	 * @return 用户数据
	 */
	User fingByuid(Integer uid);
}
