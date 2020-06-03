package com.spring.Model;
import java.sql.Date;

import com.andromeda.commons.model.BaseModel;

public class Register extends BaseModel {
public String ipaddress;
public String name;
public String email;
public String phoneno;  
public Integer districtid;     
public Integer collegeid;
public String qualification; 
public String password;
public Integer age;
public String courseid;
public String branchid;
public String regid;   
public Integer count;



public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getIpaddress() {
	return ipaddress;
}
public void setIpaddress(String ipaddress) {
	this.ipaddress = ipaddress;
}
public String getName() {    
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public Integer getDistrictid() {
	return districtid;
}
public void setDistrictid(Integer districtid) {
	this.districtid = districtid;
}
public Integer getCollegeid() {
	return collegeid;
}
public void setCollegeid(Integer collegeid) {
	this.collegeid = collegeid;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
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
public String getRegid() {
	return regid;
}
public void setRegid(String regid) {
	this.regid = regid;
}



}
