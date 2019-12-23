package com.kuwo.lmusic.entity;
/**
 * 用户数据的实体类
 * 继承了BaseEntity抽象父类
 * @author Kadel Li
 *
 */
public class User extends BaseEntity{

	/**
	 * 序列化能把堆内存中的对象的周期延长,做持久化操作,
	 * 当下次再需要这个对象的时候就不再需要new了直接从硬盘中读取就可以了
	 */
	private static final long serialVersionUID = -2456990631348917052L;
	/**类属性*/
	private Integer uid;//用户id
	private String username;//用户名称
	private String password;//密码
	private String salt;//盐值
	private String email;//邮箱
	private String avatar;//头像图片名称
	private Integer isDelete;//当前用户是否已注销0为true,1false
	private Integer lastMusic;//上次播放的歌曲的id
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getLastMusic() {
		return lastMusic;
	}
	public void setLastMusic(Integer lastMusic) {
		this.lastMusic = lastMusic;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", email="
				+ email + ", avatar=" + avatar + ", isDelete=" + isDelete + ", lastMusic=" + lastMusic
				+ ", getCreateUser()=" + getCreateUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	/**生成的equals方法由id来比较是否相等,用于给Springboot做缓存处理的,判断是否查询的是同一个*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	
}
