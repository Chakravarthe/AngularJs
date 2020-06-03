package com.spring.Model;
import java.sql.Date;

import com.andromeda.commons.model.BaseModel;
public class Program extends BaseModel {
 
	
	public String branchname;
	public String branchid;
	public String courseid;
	public String coursename;
	public String coursecode;
	public String ipaddress;
	public Date startdate;
	public Date enddate;
	public Integer programduration;
	public String durationtype;
	public Integer amount;
	public String qualification;
 
 
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

public String getIpaddress() {
	return ipaddress;
}
public void setIpaddress(String ipaddress) {
	this.ipaddress = ipaddress;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public Date getEnddate() {
	return enddate;
}
public void setEnddate(Date enddate) {
	this.enddate = enddate;
}
public Integer getProgramduration() {
	return programduration;
}
public void setProgramduration(Integer programduration) {
	this.programduration = programduration;
}
public String getDurationtype() {
	return durationtype;
}
public void setDurationtype(String durationtype) {
	this.durationtype = durationtype;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
 



}
