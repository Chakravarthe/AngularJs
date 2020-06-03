package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.spring.Service.ReportService;
@RestController
@RequestMapping("/report")
public class ReportController {    
	@Autowired
	ReportService reportService;
	    
	
     	@ResponseBody
	    @RequestMapping(value = "getAll", method = { RequestMethod.POST, RequestMethod.GET })
	   public Response getAll(@RequestBody String email)
	   {
		return reportService.getAll(email);
	   }
		@ResponseBody		    
	    @RequestMapping(value = "/getBranches", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getBranches(@RequestBody String email)
		{  
			return reportService.getBranches(email);
		}
		
		@ResponseBody	  
		@RequestMapping(value = "/getCourses", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getCourses(@RequestBody String branchid)
		{
			return reportService.getCourses(branchid);
		}
		
		
		
}
