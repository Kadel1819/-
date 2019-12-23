package com.kuwo.lmusic.service.implement;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.kuwo.lmusic.entity.User;
import com.kuwo.lmusic.mapper.UserMapper;
import com.kuwo.lmusic.service.IUserService;
import com.kuwo.lmusic.service.exception.InsertException;
import com.kuwo.lmusic.service.exception.PasswordNotMatchException;
import com.kuwo.lmusic.service.exception.UpdateException;
import com.kuwo.lmusic.service.exception.UserNotFoundException;
import com.kuwo.lmusic.service.exception.UsernameDuplicateException;



/**
 * 处理用户信息的业务类
 * @author 李钦鹏
 *
 */
@Service//业务层类一定要加的业务注解
public class UserServiceTmpl implements IUserService{

	@Autowired
	private UserMapper usermapper;

	/**
	 * 判断用户名是否被占用
	 * @param username 传进去的参数
	 */
	@Override
	public void usernameDuplicate(String username) {
		//查询数据库中是否有该用户名的用户了
		User result=usermapper.finyDataByUsername(username);
		if(result!=null) {
			throw new UsernameDuplicateException("用户名已被占用");
		}
	}
	/**
	 * 用户登录的业务具体实现
	 */
	@Override
	public void reg(User user) {
		//查询数据库中是否有该用户名的用户了
		User result=usermapper.finyDataByUsername(user.getUsername());
		if(result!=null) {
			throw new UsernameDuplicateException("用户名已被占用");
		}
		//补全数据:密码加密加盐
		String salt=UUID.randomUUID().toString().toUpperCase();
		String password = user.getPassword();//获取原密码
		String md5Password=getMd5Password(password, salt);
		user.setPassword(md5Password);//密值
		user.setSalt(salt);//盐值
		//补全数据:4个日志属性
		user.setCreateUser(user.getUsername());//创建人
		user.setCreatedTime(new Date());//创建时间
		user.setModifiedUser(user.getUsername());//最后修改人
		user.setModifiedTime(new Date());//最后修改时间
		user.setIsDelete(0);//是否删除
		//判断用户名是否被占用
		Integer rows=usermapper.insertByUserData(user);
		//判断插入数据是否成功
		if(rows!=1) {
			throw new InsertException("系统错误请联系管理员");
		}
	}
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@Override
	public User login(String username, String password) {
		//调用userMapper的findByUsername(),根据参数username查询用户数据
		User result = usermapper.finyDataByUsername(username);
		//判断查询结果是否为null
		if(result == null) {
			//是:登录失败,用户名没有对应的数据,抛出UserNotFoundException
			throw new UserNotFoundException("用户名不存在");
		}
		//判断查询结果中的isDelete是否为1
		if(result.getIsDelete() == 1) {
			//是:用户数据标记为删除,抛出UserNotFoundException
			throw new UserNotFoundException("用户数据不存在");
		}

		//从查询结果中取出salt值
		String salt = result.getSalt();
		//调用getMd5Password(String password,String salt)方法 将参数password加密 得到md5Password
		String md5Password = getMd5Password(password, salt);
		//判断查询结果中的password与以上加密得到的md5Password是否不同
		if(!result.getPassword().equals(md5Password)) {
			//是:密码错误,抛出PasswordNotMatchException
			throw new PasswordNotMatchException("密码错误");
		}

		//[1]将查询结果中除了uid.usernmae,avater以外的属性都设置为null
		//[1]返回查询结果
		//[2]创建新的User对象,将查询结果中的uid,username,avater封装到新的对象中
		User user = new User();
		user.setUid(result.getUid());
		user.setUsername(result.getUsername());
		user.setAvatar(result.getAvatar());
		//[2]返回新的user对象
		return user;
	}


	/**
	 * 修改用户密码的业务实现方法
	 */
	@Override
	public void changePassword(String username,String oldPassword, String newPassword, String code) {
		//先判断原密码是否正确
		//调用userMapper的findByUsername(),根据参数username查询用户数据
		User result = usermapper.finyDataByUsername(username);
		//判断查询结果是否为null
		if(result == null) {
			//是:登录失败,用户名没有对应的数据,抛出UserNotFoundException
			throw new UserNotFoundException("用户名不存在");
		}
		//判断查询结果中的isDelete是否为1
		if(result.getIsDelete() == 1) {
			//是:用户数据标记为删除,抛出UserNotFoundException
			throw new UserNotFoundException("用户数据不存在");
		}
		//从查询结果中取出salt值
		String salt = result.getSalt();
		//调用getMd5Password(String password,String salt)方法 将参数password加密 得到md5Password
		String md5Password = getMd5Password(oldPassword, salt);
		//判断查询结果中的password与以上加密得到的md5Password是否不同
		if(!result.getPassword().equals(md5Password)) {
			//是:密码错误,抛出PasswordNotMatchException
			throw new PasswordNotMatchException("原密码错误");
		}

		//如果原密码正确的话就在将新密码加密后存进数据库
		newPassword=getMd5Password(newPassword, salt);
		User user=new User();
		user.setUid(result.getUid());
		user.setModifiedUser(username);//最后修改人
		user.setModifiedTime(new Date());//最后修改时间
		Integer rows=updateByYan(user, newPassword);
		if(rows!=1) {
			throw new UpdateException("修改密码失败,请稍后再试,或者联系管理员");
		}
	}
	/**
	 * 更换头像
	 */
	@Override
	public void updateByuid(Integer uid, String avatar) {
		//先判断用户是否存在
		User user=fingByuid(uid);
		if(user==null) {
			throw new UserNotFoundException("非法参数,请尝试登录后在操作");
		}
		//判断查询结果中的isDelete是否为1
		if(user.getIsDelete() == 1) {
			//是:UserNotFoundException
			throw new UserNotFoundException("用户数据不存在");
		}
		//执行更新头像,并获取返回的首影响的行数
		user.setModifiedTime(new Date());
		user.setModifiedUser(user.getUsername());
		Integer rows = updateAvatar(user, avatar);
		//判断首影响的行数是否不为1
		if(rows != 1) {
			throw new UpdateException("更新头像出现未知错误,请联系管理员");
		}
	}

	/**
	 * 执行密码加密
	 * @param password 原密码
	 * @param salt 盐值
	 * @return 密值
	 */
	private String getMd5Password(String password,String salt) {
		for (int i = 0; i < 5; i++) {
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
		}
		System.err.println("\t结果：" + password);
		return password;
	}

	/**
	 * 修改用户的密码
	 * @param password 原密码 
	 * @return 执行的条数
	 */
	private Integer updateByYan(User user,String newPassword) {
		return usermapper.updateByYan(user, newPassword);
	}
	/**
	 * 更换头像
	 * @param uid
	 * @return 执行的行数
	 */
	private Integer updateAvatar(User user,String avatar) {
		return usermapper.updateAvatar(user, avatar);
	}
	/**
	 * 根据用户的id查询用户信息
	 * @param uid 用户的id
	 * @return 用户数据
	 */
	private User fingByuid(Integer uid) {
		return usermapper.fingByuid(uid);
	}
}
