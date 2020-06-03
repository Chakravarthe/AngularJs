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
import com.spring.Service.ProgramService;
import com.spring.Model.Program;
@RestController
@RequestMapping("/program")
public class ProgramController {    
	@Autowired
	ProgramService programService;
	    
		@ResponseBody		    
	    @RequestMapping(value = "/getBranches", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getBranches()
		{  
			return programService.getBranches();
		}
		
		
		@ResponseBody
		@RequestMapping(value = "add", method = { RequestMethod.POST })
		public Response add(@RequestBody Program libModel, HttpServletRequest httpServletRequest)
				throws UnsupportedEncodingException, NoSuchAlgorithmException
		{
			//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
			String clientIp = HttpUtils.getClientAddress(httpServletRequest);
			String ipaddress = "CLIENT:" + clientIp;// + ", CLIENT_PROXY:" + clientProxyIp;
			libModel.setIpaddress(ipaddress);
		
			return programService.add(libModel);
		}
		
		
}
