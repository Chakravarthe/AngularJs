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
import com.spring.Model.Form;
import com.spring.Service.FormService;

@RestController
@RequestMapping("/form")
public class FormController {

	@Autowired
	private FormService formService;
	
	
	@ResponseBody
	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public Response add(@RequestBody Form formModel, HttpServletRequest httpServletRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp;// + ", CLIENT_PROXY:" + clientProxyIp;
		formModel.setIpaddress(ipaddress);
	
		return formService.add(formModel);
	}
	
	/*@ResponseBody
	@RequestMapping(value = "getAll", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAll(@RequestBody String[] staff)
	{
		String institutioncode = staff[0];
		String role = staff[1];
		return libService.getAll(institutioncode,role);
	}
	
	@ResponseBody
	@RequestMapping(value = "removeData", method = { RequestMethod.POST })
	public Response remove(@RequestBody String name)
	{
		return libService.remove(name);
	}
	
	@ResponseBody
	@RequestMapping(value = "getById", method = { RequestMethod.POST })
	public Response getById(@RequestBody Form library)
	{
		
		return libService.getById(library);
	}
	

	@ResponseBody
	@RequestMapping(value = "getBranches", method = { RequestMethod.POST })
	public Response getBranches(@RequestBody String[] name)
	{
		
		String role= name[0];
		String institutioncode= name[0];
		return libService.getBranches(role,institutioncode);
	}
	@ResponseBody
	@RequestMapping(value = "updateData", method = { RequestMethod.POST })
	public Response updateData(@RequestBody Form lib)
	{
		return libService.updateData(lib);
	}*/
}
