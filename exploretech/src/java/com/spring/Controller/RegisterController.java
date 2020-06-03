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
import com.spring.Model.Register;
import com.spring.Service.RegisterService;
@RestController
@RequestMapping("/Reg")
public class RegisterController {
	@Autowired
	private RegisterService RegService;
	@ResponseBody
	@RequestMapping(value = {"/save"}, method = { RequestMethod.POST })
	public Response save(@RequestBody Register regModel, HttpServletRequest httpServletRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp;// + ", CLIENT_PROXY:" + clientProxyIp;
		regModel.setIpaddress(ipaddress);
	
		return RegService.add(regModel);    
	}
	
	@ResponseBody
	@RequestMapping(value = "getById", method = { RequestMethod.POST })
	public Response getById(@RequestBody String email)
	{
		return RegService.getById(email);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateProfile", method = { RequestMethod.POST })
	public Response  updateProfile(@RequestBody Register register)
	{
		return RegService.updateProfile(register);
	}  
	
	
	/*@ResponseBody
	@RequestMapping(value = "updateData", method = { RequestMethod.POST })
	public Response updateData(@RequestBody Register regModel)
	{
		return RegService.updateData(regModel);
	}*/
}
