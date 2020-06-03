package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.Model.Course;

@Repository    
public class CourseDAO extends BaseDAO {
	
	
	
	
	public List<Course> getCourses(String branchid)
	{
		List<Course> data = sqlSessionTemplate.selectList("Course.getCourses",branchid);
		return  data;
	}

	public List<Course> getBranches()
	{
		
		List<Course> data = sqlSessionTemplate.selectList("Course.getBranches");
		return  data;
	}
	
	public List<Course> getColleges(Integer districtid)
	{
		List<Course> data = sqlSessionTemplate.selectList("Course.getColleges",districtid);
		return  data;
	}
	public List<Course> getPolyColleges(Integer districtid)
	{
		List<Course> data = sqlSessionTemplate.selectList("Course.getPolyColleges",districtid);
		return  data;
	}
	
    
	public List<Course> getDistricts()
	{
		
		List<Course> data = sqlSessionTemplate.selectList("Course.getDistricts");
		return  data;
	}
	
	
	public Course getAmount(String courseid)
	{
		Course list = sqlSessionTemplate.selectOne("Course.getAmount",courseid);
		return list;     
	}
}
