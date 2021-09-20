package com.mvc.bean;

public class LoginBean {
	
	private String userName;
	private String password;
	private String firstLog; //tracks if this is users first time logging in
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;		
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;		
	}
	
	public String getfirstLog() {
		return firstLog;
	}
	public void setfirstLog(String firstlog) {
		this.firstLog = firstLog;
	}

}
