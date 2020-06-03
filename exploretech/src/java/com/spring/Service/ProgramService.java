package com.spring.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.ProgramDAO;
import com.spring.Model.Program;


@Service
public class ProgramService {
	@Autowired
	ProgramDAO programDAO;
	Response response = new Response();
	
	public Response getBranches()
	{
		response.setSuccessful(false);
		List<Program> data = programDAO.getBranches();
		response.setResponseObject(data);
		response.setSuccessful(true);
		return response;
	}
	
	
	public Response add(Program branch) {
		response.setSuccessful(false);
		programDAO.add(branch);
		response.setSuccessful(true);
		response.setResponseObject(branch);
		return response;
	}    
	
}
