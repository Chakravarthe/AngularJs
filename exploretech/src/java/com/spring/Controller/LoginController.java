package com.spring.Controller;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;


/*import in.apssdc.model.FileModel;*/
import com.spring.Model.Login;
import com.spring.Service.LoginService;                

@RestController
@RequestMapping("/login")
public class LoginController           
{
	@Autowired
	private LoginService loginService;

	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public Response login(@RequestBody Login login, HttpServletRequest httpServletRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp ;//+ ", CLIENT_PROXY:" + clientProxyIp;
		login.setIpaddress(ipaddress);
		return loginService.login(login);
	}        

	@ResponseBody
	@RequestMapping(value = "loggedin", method = { RequestMethod.POST })
	public Boolean isUserLoggedIn(@RequestBody Login login)
	{
		Boolean status = loginService.isUserLoggedIn(login);
		return status;
	}
	@ResponseBody
	@RequestMapping(value = "validateAadhaar", method = { RequestMethod.POST })
	public Response validateAadhaar(@RequestBody String aadhaar)
	{
		System.out.println("--AADHAAR--");
		System.out.println(aadhaar);
		return loginService.validateAadhaar(aadhaar);
	}
	@ResponseBody
	@RequestMapping(value = "/logout", method = { RequestMethod.POST })
	public void logout(@RequestBody Login login)
	{
		String username = login.getEmail();
		if (username != null)
		{
			loginService.logout(username);
		}
	}

	

}