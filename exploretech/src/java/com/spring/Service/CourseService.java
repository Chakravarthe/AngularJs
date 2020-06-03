package com.spring.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.CourseDAO;
import com.spring.Model.Course;


@Service
public class CourseService {
	@Autowired
	CourseDAO courseDAO;
	Response response = new Response();
	
	public Response getBranches()
	{
		response.setSuccessful(false);
		List<Course> data = courseDAO.getBranches();
		response.setResponseObject(data);
		response.setSuccessful(true);
		return response;
	}
	
	public Response getCourses(String branchid)
	{
		response.setSuccessful(false);
	List<Course> data = courseDAO.getCourses(branchid);
	response.setResponseObject(data);
	response.setSuccessful(true);
	return response;
	}
	
	public Response getDistricts()
	{
		response.setSuccessful(false);
		List<Course> data = courseDAO.getDistricts();
		response.setResponseObject(data);
		response.setSuccessful(true);
		return response;
	}
	
	public Response getColleges(Integer districtid)
	{
		response.setSuccessful(false);
	List<Course> data = courseDAO.getColleges(districtid);
	response.setResponseObject(data);
	response.setSuccessful(true);            
	return response;
	}                 
	
	public Response getPolyColleges(Integer districtid)
	{
		response.setSuccessful(false);
	List<Course> data = courseDAO.getPolyColleges(districtid);
	response.setResponseObject(data);
	response.setSuccessful(true);
	return response;
	}
	
	public Response getAmount(String courseid)
	{
	response.setSuccessful(false);
	Course data = courseDAO.getAmount(courseid);
	response.setResponseObject(data);
	response.setSuccessful(true);
	return response;
	}
}
