package com.kuwo.lmusic.entity;
/**
 * 实体类的基类抽象
 * 实现序列化接口:
 * 序列化能把堆内存中的对象的声明周期延长,做持久化操作,
 * 当下次再需要这个对象的时候就不需要new了直接从硬盘中读取就可以了
 * @author Kadel Li
 *
 */

import java.io.Serializable;
import java.util.Date;

abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -6029218815951977273L;
	/**类属性*/
	private String createUser;//创建人
	private Date createdTime;//创建时间
	private String modifiedUser;//修改人
	private Date modifiedTime;//修改时间
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseEntity [createUser=" + createUser + ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	
}
