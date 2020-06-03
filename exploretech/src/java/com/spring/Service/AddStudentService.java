package com.spring.Service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.AddStudentDAO;                                          
import com.spring.Model.AddStudent;

@Service
public class AddStudentService {
	Response response = new Response();

	@Autowired
	private AddStudentDAO addStudentDAO;
	
	public Response getYear()
	{
		response.setSuccessful(false);
		AddStudent data = addStudentDAO.getYear();
	response.setResponseObject(data);
	response.setSuccessful(true);
	return response;
	}
	
	
	 public Response saveDetails(List<AddStudent> student, String ipAddress, List<String> pathsList)
	  {
	    this.response.setSuccessful(false);
	    Map<String, Object> list=this.addStudentDAO.saveDetails(student, ipAddress);
	    
	    AddStudent filePathsMail = new AddStudent();
	    
	    filePathsMail.setPaths(pathsList);
	    
	   // mailSend(filePathsMail);
	    
	    this.response.setSuccessful(true);
	    response.setResponseObject(list);
	    
	    return this.response;
	  }
	 
	/*public Response add(AddStudent addStudent) {                 
		response.setSuccessful(false);
		addStudentDAO.add(addStudent);
		response.setSuccessful(true);
		response.setResponseObject(addStudent);
		return response;
	}*/
  
	public Response getAll() {
		response.setSuccessful(false);
		List<AddStudent> condetails = addStudentDAO.getAll();
		response.setSuccessful(true);
		response.setResponseObject(condetails);
		return response;
	}

	public Response remove(String firstname)
	{
		response.setSuccessful(false);
		addStudentDAO.remove(firstname);
		response.setSuccessful(true);
		response.setResponseObject(firstname);
		return response;
	}

	public Response getById(String firstname)
	{
		response.setSuccessful(false);
		AddStudent singleuserdetails = addStudentDAO.getById(firstname);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		return response;
	}

	public Response updateData(AddStudent addStudent)
	{
		response.setSuccessful(false);
		addStudentDAO.updateData(addStudent);
		response.setSuccessful(true);
		response.setResponseObject(addStudent);
		return response;
	}
	

}
