package com.spring.Model;

import java.util.List;

import com.andromeda.commons.model.BaseModel;

public class College extends BaseModel
{
	private Integer userId;
	private Integer districtid;
	private String districtname;
	private String institutionname;
    private String mobileno;
	private String email;
	private String email1;
	private String principalname;     
	private String password;
	private String enyptPassword;
	private String ipAddress;        
	private Integer id;
	private String pwd;
	private String userStatus;
	private String role;
	public Integer status;
	public String institutioncode;
    public String username;

  

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Integer getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	public String getInstitutioncode() {
		return institutioncode;
	}

	public void setInstitutioncode(String institutioncode) {
		this.institutioncode = institutioncode;
	}

	
	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getInstitutionname() {
		return institutionname;
	}

	public void setInstitutionname(String institutionname) {
		this.institutionname = institutionname;
	}

	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
	public String getPrincipalname() {
		return principalname;
	}

	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
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
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
}