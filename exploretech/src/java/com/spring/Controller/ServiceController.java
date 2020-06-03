package com.spring.Controller;

import com.spring.Model.College;

import com.spring.Service.ServiceService;

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

@RestController
@RequestMapping("/service")
public class ServiceController
{
	@Autowired
	ServiceService serviceService;

	@ResponseBody
	@RequestMapping(value = { "/getLogins" }, method = { RequestMethod.POST })
	public Response getLogins(@RequestBody String institutioncode)
	{
		return serviceService.getLogins(institutioncode);
	}

	@ResponseBody
	@RequestMapping(value = "/createLogin", method = { RequestMethod.POST })
	private Response createLogin(@RequestBody College details,
			HttpServletRequest httpServletRequest) throws JSONException
	{
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp /*+ ", CLIENT_PROXY:" + clientProxyIp*/;
		details.setIpAddress(ipaddress);
		return serviceService.createLogin(details);
	}
    @ResponseBody
	@RequestMapping(value = "/getDistricts", method = { RequestMethod.POST, RequestMethod.GET })
	private Response getDistricts()
	{
		return serviceService.getDistricts();
	}

	@ResponseBody
	@RequestMapping(value = "/getColleges", method = { RequestMethod.POST })
	private Response getColleges()
	{
		return serviceService.getColleges();
	}
/*
	@ResponseBody
	@RequestMapping(value = "/getCollegeDetails", method = { RequestMethod.POST })
	private Response getCollegeDetails(@RequestBody Integer districtId)
	{
		return serviceService.getCollegeDetails(districtId);
	}
*/
	/*@ResponseBody
	@RequestMapping(value = "/getLink", method = { RequestMethod.POST })
	private Response getLink(@RequestBody College college) throws JSONException
	{
		return serviceService.getLink(college);
	}

	@ResponseBody
	@RequestMapping(value = { "/checkAadhaar" }, method = { RequestMethod.POST })
	public Response checkAadhaar(@RequestBody String aadhaar)
	{
		return serviceService.checkAadhaar(aadhaar);
	}

	@ResponseBody
	@RequestMapping(value = { "/getStudentDetails" }, method = { RequestMethod.POST })
	public Response getStudentDetails(@RequestBody String registrationId)
	{
		return serviceService.getStudentDetails(registrationId);
	}

	@ResponseBody
	@RequestMapping(value = { "/changeStudentCourse" }, method = { RequestMethod.POST })
	public Response changeStudentCourse(@RequestBody Student student,
			HttpServletRequest httpServletRequest)
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		student.setIpAddress(ipAddress);
		
		 * System.out.println("--> Student details"); System.out.println(student);
		 
		return serviceService.changeStudentCourse(student);
	}

	@ResponseBody
	@RequestMapping(value = { "/getTrainingPrograms" }, method = { RequestMethod.POST })
	public Response getTrainingPrograms(@RequestBody College details)
	{
		return serviceService.getTrainingPrograms(details);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getTrainingPrograms1" }, method = { RequestMethod.POST })
	public Response getTrainingPrograms1(@RequestBody College details)
	{
		return serviceService.getTrainingPrograms1(details);
	}

	@ResponseBody
	@RequestMapping(value = { "/getProgramsDetails" }, method = { RequestMethod.POST })
	public Response getProgramsDetails(@RequestBody Integer trainingProgramId)
	{
		return serviceService.getProgramsDetails(trainingProgramId);
	}
	@ResponseBody
	@RequestMapping(value = "/getActivePrograms", method = { RequestMethod.POST })
	private Response getActivePrograms(@RequestBody Integer collegeId)
	{
		return serviceService.getActivePrograms(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "/getCourses", method = { RequestMethod.POST })
	private Response getCourses(@RequestBody Integer programId)
	{
		return serviceService.getCourses(programId);
	}

	@ResponseBody
	@RequestMapping(value = "/getStudents", method = { RequestMethod.POST })
	private Response getStudents(@RequestBody Student student) throws JSONException
	{
		return serviceService.getStudents(student);
	}*/
}