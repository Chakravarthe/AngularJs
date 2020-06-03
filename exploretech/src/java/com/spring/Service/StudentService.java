package com.spring.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.CryptoUtils;
import com.spring.DAO.StudentDAO;
import com.spring.Model.Student;
@Service
public class StudentService {
	Response response = new Response();

	@Autowired
	private StudentDAO stuDAO;

	public Response getAll(String email) {
		response.setSuccessful(false);
		List<Student> userdetails = stuDAO.getAll(email);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
}
