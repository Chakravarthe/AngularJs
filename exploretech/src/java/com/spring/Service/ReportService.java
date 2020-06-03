package com.spring.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.ReportDAO;
import com.spring.Model.Report;
import com.spring.Model.Student;


@Service
public class ReportService {
	@Autowired
	ReportDAO reportDAO;
	Response response = new Response();
	
	
	public Response getAll(String email) {
		response.setSuccessful(false);
		Report userdetails = reportDAO.getAll(email);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;     
	}
	public Response getBranches(String email)
	{
		response.setSuccessful(false);
		List<Report> data = reportDAO.getBranches(email);
		response.setResponseObject(data);
		response.setSuccessful(true);
		return response;
	}
	
	public Response getCourses(String branchid)
	{
		response.setSuccessful(false);
	List<Report> data = reportDAO.getCourses(branchid);
	response.setResponseObject(data);
	response.setSuccessful(true);
	return response;
	}
	
	
}
