package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;
import com.spring.Model.MentorsModel;
import com.spring.Service.MentorsServiceService;
@RestController
@RequestMapping("/mentorsservice")
public class MentorsController          
{
	@Autowired
	MentorsServiceService mentorsServiceService;
	
	@ResponseBody
	@RequestMapping(value = "/createLogin", method = { RequestMethod.POST })
	private Response createLogin(@RequestBody MentorsModel details,
			HttpServletRequest httpServletRequest) throws JSONException
	{
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp /*+ ", CLIENT_PROXY:" + clientProxyIp*/;
		details.setIpaddress(ipaddress);
		return mentorsServiceService.createLogin(details);
	}
	
	        
}
