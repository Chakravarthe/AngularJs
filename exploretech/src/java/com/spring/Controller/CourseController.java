package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.spring.Service.CourseService;
@RestController
@RequestMapping("/course")
public class CourseController {    
	@Autowired
	CourseService courseService;
	    
		@ResponseBody		    
	    @RequestMapping(value = "/getBranches", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getBranches()
		{  
			return courseService.getBranches();
		}
		
		@ResponseBody	  
		@RequestMapping(value = "/getCourses", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getCourses(@RequestBody String branchid)
		{
			return courseService.getCourses(branchid);
		}
		
		
		@ResponseBody		    
	    @RequestMapping(value = "/getDistricts", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getDistricts()
		{
			return courseService.getDistricts();
		}
		                            
		@ResponseBody	  
		@RequestMapping(value = "/getColleges", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getColleges(@RequestBody Integer districtid)
		{
			return courseService.getColleges(districtid);
		}
		@ResponseBody	  
		@RequestMapping(value = "/getPolyColleges", method = { RequestMethod.POST, RequestMethod.GET })
		private Response getPolyColleges(@RequestBody Integer districtid)
		{
			return courseService.getPolyColleges(districtid);
		}
		
		
	 @ResponseBody
		@RequestMapping(value = { "getAmount" }, method = { RequestMethod.POST, RequestMethod.GET })
		public Response getAmount(@RequestBody String courseid)
		{   
			return courseService.getAmount(courseid);
		}
}
