package com.spring.Service;
      
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;
import com.spring.DAO.MentorsServiceDAO;    
import com.spring.Model.MentorsModel;
import com.spring.Model.Email;     

@Service

public class MentorsServiceService {    
	Response response = new Response();	
	@Autowired
	MentorsServiceDAO mentorsServiceDAO;
         

	
	
	public Response createLogin(MentorsModel details)
	{
		
		response.setSuccessful(false);
		MentorsModel login =mentorsServiceDAO.createLogin(details);
        Email email = new Email();
		email.setFrom("SBTET <joinus@apssdc.in>");
		email.setTo(details.getMentorsemail().trim());
		email.setSubject("SBTET");
		String msg = "Dear Sir/Madam,<br><br>"+
		"Email: "+details.getMentorsemail()
		+ "Password: "+details.getPassword();
		email.setText(msg);
		response.setSuccessful(true);
		response.setResponseObject(login);
		return response;
	}
	
	
	
	
	
}
