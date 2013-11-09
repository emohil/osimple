package com.bms.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bms.base.domain.BaseDomain;

@Entity(name="t_user")
public class User extends BaseDomain {
	/**
	 * 仅用于登录.
	 */
	@Column(name="user_id", length=20)
	private String userId;
	
	@Column(name="user_name", length=60)
	private String userName;
	
	@Column(name="pass_word", length=20)
	private String passWord;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
