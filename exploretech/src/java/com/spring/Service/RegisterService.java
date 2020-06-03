package com.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.CryptoUtils;
import com.spring.DAO.RegisterDAO;
import com.spring.Model.Register;
@Service
public class RegisterService {
	Response response = new Response();

	@Autowired
	private RegisterDAO regDAO;

	public Response add(Register regModel) {
		regModel.setPassword(CryptoUtils.getMD5Hash(regModel.getPassword()));
		response.setSuccessful(false);
		regDAO.add(regModel);    
		response.setSuccessful(true);
		response.setResponseObject(regModel);                     
		return response;     
	} 
	public Response getById(String email)
	{
		response.setSuccessful(false);
		Register register= regDAO.getById(email);
		response.setSuccessful(true);
		response.setResponseObject(register);
		return response;
	}
	
	public Response updateProfile(Register register)
	{
		response.setSuccessful(false);
		regDAO.updateProfile(register);
		response.setSuccessful(true);
		response.setResponseObject(register);
		return response;
	}
	/*public Response updateData(Register email)
	{
		response.setSuccessful(false);
		regDAO.updateData(email);
		response.setSuccessful(true);
		response.setResponseObject(email);
		return response;
	}*/
}
