package com.kuwo.lmusic.mapper;
import java.util.Date;

import org.junit.Test;
/**
 * 用户持久层测试类
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuwo.lmusic.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper mapper;
	
	/**
	 * 查询当前用户的数据
	 * @param username 用户名
	 * @return 用户数据
	 */
	@Test
	public void finyDataByUsername() {
		User user=mapper.finyDataByUsername("张三");
		System.err.println(user);
	}
	@Test
	public void insertByUserData() {
		User user=new User();
		user.setUsername("qwewer");
		user.setPassword("123123");
		Integer rows=mapper.insertByUserData(user);
		System.err.println("rows"+rows);
	}
	@Test
	public void updateAvatar() {
		User user=new User();
		user.setModifiedTime(new Date());
		user.setUid(8);
		user.setModifiedUser("adsf");
		Integer users=mapper.updateAvatar(user,"adf");
		System.err.println(users);
	}
	@Test
	public void fingByuid() {
		User user=mapper.fingByuid(8);
		System.err.println(user);
	}
}
