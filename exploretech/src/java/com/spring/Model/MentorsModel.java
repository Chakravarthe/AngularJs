package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class MentorsModel extends BaseModel{
	private static final long serialVersionUID = 1L;
	private Integer userId;
    private String phoneno;
	private String mentorsemail;
	private String mentorsname;     
	private String password;
	private String enyptPassword;
	private String ipaddress;        
	private Integer id;
	private String pwd;
	private String userStatus;
	public String courseid;
	public String branchid;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getMentorsemail() {
		return mentorsemail;
	}
	public void setMentorsemail(String mentorsemail) {
		this.mentorsemail = mentorsemail;
	}
	public String getMentorsname() {
		return mentorsname;
	}
	public void setMentorsname(String mentorsname) {
		this.mentorsname = mentorsname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnyptPassword() {
		return enyptPassword;
	}
	public void setEnyptPassword(String enyptPassword) {
		this.enyptPassword = enyptPassword;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserStatus() {
		return userStatus;   
	}                       
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getBranchid() {
		return branchid;   
	}
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	
}
