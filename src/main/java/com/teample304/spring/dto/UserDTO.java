package com.teample304.spring.dto;

import org.springframework.stereotype.Repository;

@Repository
public class UserDTO {
	private String userid;
	private String userpw;
	private String username;
	private String userphone;
	
	public String getUserid() {return userid;}
	public String getUserpw() {return userpw;}
	public String getUsername() {return username;}
	public String getUserphone() {return userphone;}
	public void setUserid(String userid) {this.userid = userid;}
	public void setUserpw(String userpw) {this.userpw = userpw;}
	public void setUsername(String username) {this.username = username;}
	public void setUserphone(String userphone) {this.userphone = userphone;}
	
}
