package com.kuwo.lmusic.entity;
/**
 * 歌曲实体类	
 * @author 李钦鹏
 *
 */
public class Song extends BaseEntity {


	private static final long serialVersionUID = -6807588754235098287L;
	private Integer mid;//歌曲的id
	private Integer sid;//归属的歌手
	private Integer aid;//归属的专辑id
	private String avatar;//本歌曲的图片
	private String musicName;//歌曲的名字
	private String path;//歌曲文件所在的路径
	private String lyric;//歌词文件所在的位置
	private Long hits;//歌曲的点击量
	private Integer type;//歌曲类型
	private Integer isDelete;//是否删除上线或下线
	
	
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public String toString() {
		return "Song [mid=" + mid + ", sid=" + sid + ", aid=" + aid + ", avatar=" + avatar + ", musicName=" + musicName
				+ ", path=" + path + ", lyric=" + lyric + ", hits=" + hits + ", type=" + type + ", isDelete=" + isDelete
				+ ", getCreateUser()=" + getCreateUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
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
		Song other = (Song) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		return true;
	}
	
}
