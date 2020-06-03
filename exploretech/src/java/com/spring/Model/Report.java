package com.spring.Model;
import com.andromeda.commons.model.BaseModel;
public class Report extends BaseModel {
 
	public String mentorsname;
	public String branchname;
	public String branchid;
	public String courseid;
    public String coursename;
     
   
 
       
	public String getMentorsname() {   
		return mentorsname;
	}
	public void setMentorsname(String mentorsname) {
		this.mentorsname = mentorsname;
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
 
}
