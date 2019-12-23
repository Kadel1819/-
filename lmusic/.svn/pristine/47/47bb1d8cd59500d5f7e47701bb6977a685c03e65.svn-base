package com.kuwo.lmusic.service;
import org.junit.Test;
/**
 * 用户持久层测试类
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.User;
import com.kuwo.lmusic.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	@Autowired
	private IUserService iUserService;
	/**
	 * 查询当前用户的数据
	 * @param username 用户名
	 * @return 用户数据
	 */
	@Test
	public void usernameDuplicate() {
		try {
			iUserService.usernameDuplicate("张b三");
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
	}
	/**
	 * 测试用户注册
	 */
	@Test
	public void reg() {
		try {
			User user=new User();
			user.setUsername("张三");
			user.setPassword("123123");
			iUserService.reg(user);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
	}
	/**
	 * 测试用户登录
	 */
	@Test
	public void login() {
		try {
			
			iUserService.login("张张张", "12312n3");
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
	}
	/**
	 * 测试用户修改密码
	 */
	@Test
	public void update() {
		try {
			
			iUserService.changePassword("张三", "1233123", "aaa", "aaa");
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
	}
	@Test
	public void updateByuid() {
		try {
			
			iUserService.updateByuid(8, "adsfdd");
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
	}
}
