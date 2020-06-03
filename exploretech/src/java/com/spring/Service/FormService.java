package com.spring.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.FormDAO;
import com.spring.Model.Form;

@Service
public class FormService {

	Response response = new Response();

	@Autowired
	private FormDAO formDAO;

	public Response add(Form form) {
		response.setSuccessful(false);
		formDAO.add(form);
		response.setSuccessful(true);
		response.setResponseObject(form);
		return response;
	}                                                   
	/*public Response getCourses()
	{
		response.setSuccessful(false);
		List<Map<String, Object>> list = libDAO.getCourses();
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}
	public Response getAll(String institutioncode,String role) {
		response.setSuccessful(false);
		List<Form> userdetails = libDAO.getAll(institutioncode,role);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response remove(String branch)
	{
		response.setSuccessful(false);
		libDAO.remove(branch);
		response.setSuccessful(true);
		response.setResponseObject(branch);
		return response;
	}

	public Response getById(Form library)
	{
		response.setSuccessful(false);
		Form singleuserdetails = libDAO.getById(library);
		response.setSuccessful(true);  
		response.setResponseObject(singleuserdetails);
		return response;
	}

	public Response getBranches(String role,String institution)
	{
		response.setSuccessful(false);
		List<Form> singleuserdetails = libDAO.getBranches(role,institution);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		return response;
	}
	
	public Response updateData(Form branch)
	{
		response.setSuccessful(false);
		libDAO.updateData(branch);
		response.setSuccessful(true);
		response.setResponseObject(branch);
		return response;
	}*/
	

}
