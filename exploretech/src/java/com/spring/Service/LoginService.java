package com.spring.Service;

import com.spring.Model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.spring.DAO.LoginDAO;
import com.andromeda.commons.util.AadhaarUtils;
import com.andromeda.commons.util.CryptoUtils;
import com.andromeda.commons.util.IDGenerator;

@Service
public class LoginService
{
	@Autowired
	private LoginDAO loginDAO;

	

	Response response = new Response();

	public Response login(Login login)     
	{
		response.setSuccessful(false);    
		login.setPassword(CryptoUtils.getMD5Hash(login.getPassword()));
		Integer loginStatus = loginDAO.checkUser(login);

		if (loginStatus == 0)
		{
			response.setSuccessful(false);
		}
		else if (loginStatus > 0)
		{
			Login details = loginDAO.getUserDetails(login);
			details.setIpaddress(login.getIpaddress());
			

			loginDAO.saveToLogins(details);

			response.setSuccessful(true);
			response.setResponseObject(details);
		}
		return response;
	}
  /*public Response login(Login login)
  {
    this.response.setSuccessful(false);
    
    Integer userStatus = this.loginDAO.checkUser(login);
    if (userStatus.intValue() == 0)
    {
      this.response.setSuccessful(false);
    }
    else if (userStatus.intValue() > 0)
    {
      Login details = this.loginDAO.getUserDetails(login);
      details.setContext(IDGenerator.getUniqueID());
      details.setIpAddress(login.getIpAddress());
      details.setIpAddress("");
      
      this.loginDAO.saveToLogins(details);
      
      this.response.setSuccessful(true);
      this.response.setResponseObject(details);
    }
    return this.response;
  }*/
	public Boolean isUserLoggedIn(Login login)
	{
		Boolean status = false;
		if ((!StringUtils.isEmpty(login.getEmail()))
				&& (!StringUtils.isEmpty(login.getPassword())))
		{
			Integer loginStatus = loginDAO.isUserLoggedIn(login);
			/*System.out.println("-------------------------");
			System.out.println(loginStatus);
			System.out.println("-------------------------");*/
			if (loginStatus == 0)
			{
				status = false;
			}
			else if (loginStatus > 0)
			{
				status = true;
			}
		}

		return status;
	}

	public Response validateAadhaar(String aadhaar)
	{
		response.setSuccessful(false);

		if (AadhaarUtils.isValidAadhaar(aadhaar))
		{
			response.setSuccessful(true);
		}
		else
		{
			response.setSuccessful(false);
		}   
		return response;
	}
	public void logout(String email)
	{
		loginDAO.deleteLoginLog(email);
	}

	

	
}