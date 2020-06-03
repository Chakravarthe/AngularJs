package com.spring.Model;
import com.andromeda.commons.model.BaseModel;
public class Course extends BaseModel {
 
	
	public String branchname;
	public String branchid;
	public String courseid;
 public String coursename;
 public String districtname;
	public Integer districtid;
	public Integer collegeid;
public String collegename;
 public String coursecode;
 public Integer amount;
 
 
public String getBranchname() {
	return branchname;
}
public void setBranchname(String branchname) {
	this.branchname = branchname;
}

public String getBranchid() {
	return branchid;
}
public void setBranchid(String branchid) {
	this.branchid = branchid;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}

public String getCourseid() {
	return courseid;
}
public void setCourseid(String courseid) {
	this.courseid = courseid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public String getCoursecode() {
	return coursecode;
}
public void setCoursecode(String coursecode) {
	this.coursecode = coursecode;
}
public String getDistrictname() {
	return districtname;
}
public void setDistrictname(String districtname) {
	this.districtname = districtname;
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
public String getCollegename() {
	return collegename;
}
public void setCollegename(String collegename) {
	this.collegename = collegename;
}
 
}
