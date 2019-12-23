package com.kuwo.lmusic.entity;

/**
 * 歌曲数据的实体类
 * 继承了BaseEntity抽象父类
 * @author Kadel Li
 *
 */
public class Singer extends BaseEntity {

	private static final long serialVersionUID = -8182189795960019047L;
	
	private Integer sid;//歌手id
	private String name;//歌手名字
	private Integer gender;//歌手性别
	private Integer age;//歌手年龄
	private String avatar;//歌手图片路径名称
	private String nationality;//歌手国籍
	private Integer isDelete;//歌手状态
	
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		Singer other = (Singer) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Singer [sid=" + sid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", avatar=" + avatar
				+ ", nationality=" + nationality + ", isDelete=" + isDelete + ", getCreateUser()=" + getCreateUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}
	
	

	
}
