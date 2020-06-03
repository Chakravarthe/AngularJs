package com.spring.Service;

import java.util.List;
import java.util.Map;
import org.json.JSONException;      
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;
import com.spring.DAO.ServiceDAO;
import com.spring.Model.College;
import com.spring.Model.Email;
/*import com.spring.Model.Enroll;*/
import com.spring.Service.EmailService;
import com.spring.Service.ServiceService;
@Service
public class ServiceService
{
	@Autowired
	ServiceDAO serviceDAO;

	@Autowired
	EmailService emailService;
	ServiceService serviceService;
	Response response = new Response();

	/*public Response getCollegeDetails()
	{
		response.setSuccessful(false);
		Map<String, Object> details = serviceDAO.getCollegeDetails();
		response.setSuccessful(true);
		response.setResponseObject(details);
		return response;
	}*/

	public Response getDistricts()
	{
		response.setSuccessful(false);
		List<Map<String, Object>> districts = serviceDAO.getDistricts();
		response.setSuccessful(true);
		response.setResponseObject(districts);
		return response;
	}
	
	public Response getColleges()
	{
		response.setSuccessful(false);
		List<Map<String, Object>> colleges = serviceDAO.getColleges();
		response.setSuccessful(true);
		response.setResponseObject(colleges);
		return response;
	}
	/*public Response getData(String institutioncode)
	{
		response.setSuccessful(false);
		College list = serviceDAO.getData(institutioncode);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}*/
	public Response getLogins(String institutioncode)
	{
		response.setSuccessful(false);
		List<Map<String, Object>> logins = serviceDAO.getLogins(institutioncode);
		if (logins == null)
		{
			response.setSuccessful(false);
			response.setErrorMessage(
					"No data available, create login credentials using 'Create login credentials' option");
		}
		else
		{
			response.setSuccessful(true);
			response.setResponseObject(logins);
		}
		return response;
	}
                 
	public Response createLogin(College details)
	{
		response.setSuccessful(false);
		College login =serviceDAO.createLogin(details);
        Email email = new Email();
		email.setFrom("SBTET <joinus@apssdc.in>");
		email.setTo(details.getEmail().trim());
		email.setSubject("SBTET");
		String msg = "Dear Sir/Madam,<br><br>"+
		"Email: "+details.getEmail()
		+ "Password: "+details.getPassword();
		email.setText(msg);
		response.setSuccessful(true);
		response.setResponseObject(login);
		return response;
	}
	
	
	private Response mailSend(College details) throws JSONException
	{
		
		Email email = new Email();
		email.setFrom("SBTET <joinus@apssdc.in>");
		email.setTo(details.getEmail().trim());
		email.setSubject("APSSDC  Exression of Intereset (EoI) – Verification Code");

		String msg = "Dear Sir/Madam,<br><br>"+
			 "Email: "+details.getEmail()
				+ "Password: "+details.getPassword();

		email.setText(msg);

		boolean status = emailService.sendHtmlMsg(email);

		response.setSuccessful(status);
		response.setResponseObject(details);
		return response;
	}

	/*public Response getLink(College college) throws JSONException
	{
		response.setSuccessful(false);
		Map<String, Object> resultMap = serviceDAO.getLink(college);

		if (resultMap.get("message") == null)
		{
			JSONObject json = new JSONObject();
			json.put("collegeId", college.getCollegeId());
			json.put("trainingBatchId", resultMap.get("newBatchId"));
			String str = json.toString();
			byte[] byteStr = Base64.encodeBase64(str.getBytes());
			String finalStr = new String(byteStr);

			String msg = "http://engineering.apssdc.in/studentSubscribe?q=" + finalStr;

			response.setSuccessful(true);
			response.setResponseObject(msg);
		}
		else
		{
			response.setSuccessful(true);
			response.setResponseObject(resultMap.get("message"));
		}

		return response;
	}

	public Response checkAadhaar(String aadhaar)
	{
		response.setSuccessful(false);
		List<Student> studentDetails = serviceDAO.getStudentDetails(aadhaar);

		if (studentDetails.size() == 0)
		{
			response.setSuccessful(false);
			response.setErrorMessage("No records found with given details");
		}
		else
		{
			response.setSuccessful(true);
			response.setResponseObject(studentDetails);
		}

		return response;
	}

	public Response getStudentDetails(String registrationId)
	{
		response.setSuccessful(false);
		List<Student> studentDetails = serviceDAO.getStudentDetails(registrationId);

		if (studentDetails.size() == 0)
		{
			response.setSuccessful(false);
			response.setErrorMessage("No records found with given details");
		}
		else
		{
			response.setSuccessful(true);
			response.setResponseObject(studentDetails);
		}

		return response;
	}

	public Response changeStudentCourse(Student student)
	{
		response.setSuccessful(false);
		serviceDAO.changeStudentCourse(student);
		response.setSuccessful(true);
		return response;
		// Boolean status = serviceDAO.changeStudentCourse(student);
		
		 * if (status) { Map<String, Object> courseDetails = serviceDAO.getProgramNames(student);
		 * Email email = new Email(); email.setSubject("APSSDC : SIP course updation details");
		 * email.setFrom("joinus@apssdc.in"); email.setTo(student.getEmail()); String msg =
		 * "Dear Student," + "<br><br>" + "You have registered for, " + "<br><ul><li>" +
		 * courseDetails.get("prevProgramName") + " - " + courseDetails.get("prevCourseName") +
		 * "</li></ul><br>" + ".Your course has been updated to, " + "<ul><li>" +
		 * courseDetails.get("programName") + " - " + courseDetails.get("courseName") +
		 * "</li></ul>"; email.setText(msg); // emailService.sendHtmlMsg(email);
		 * response.setSuccessful(true); } else { response.setSuccessful(false); }
		 
	}

	public Response getTrainingPrograms(College details)
	{
		response.setSuccessful(false);
		List<College> programs = serviceDAO.getTrainingPrograms(details);
		response.setSuccessful(true);
		response.setResponseObject(programs);
		return response;
	}
	
	public Response getTrainingPrograms1(College details)
	{
		response.setSuccessful(false);
		List<College> programs = serviceDAO.getTrainingPrograms1(details);
		response.setSuccessful(true);
		response.setResponseObject(programs);
		return response;
	}

	public Response getProgramsDetails(Integer trainingProgramId)
	{
		response.setSuccessful(false);
		List<College> programs = serviceDAO.getProgramsDetails(trainingProgramId);
		response.setSuccessful(true);
		response.setResponseObject(programs);
		return response;
	}*/


/*	public Response getActivePrograms(Integer collegeId)
	{
		response.setSuccessful(false);
		List<Student> programs = serviceDAO.getActivePrograms(collegeId);
		response.setSuccessful(true);
		response.setResponseObject(programs);
		return response;
	}

	public Response getCourses(Integer programId)
	{
		response.setSuccessful(false);
		List<Student> courses = serviceDAO.getCourses(programId);
		response.setSuccessful(true);
		response.setResponseObject(courses);
		return response;
	}

	public Response getStudents(Student student) throws JSONException
	{
		response.setSuccessful(false);
		String programType = serviceDAO.getProgramType(student);
		List<Student> students = serviceDAO.getStudents(student);
		if (students.size() > 0 || students != null)
		{
			if (programType.equalsIgnoreCase("-"))
			{

			}
			else if (programType.equalsIgnoreCase("SIP")
					|| programType.equalsIgnoreCase("WORKSHOP"))
			{
				for (int i = 0; i < students.size(); i++)
				{
					JSONObject json = new JSONObject();
					json.put("guid", students.get(i).getGuid());
					String str = json.toString();
					byte[] byteStr = Base64.encodeBase64(str.getBytes());
					String finalStr = new String(byteStr);
					String url = "http://engineering.apssdc.in/trainee?q:=" + finalStr;
					students.get(i).setUrl(url);
				}
			}
			else if (programType.equalsIgnoreCase("CERTIFICATION"))
			{
				for (int i = 0; i < students.size(); i++)
				{
					JSONObject json = new JSONObject();
					json.put("guid", students.get(i).getGuid());
					String str = json.toString();
					byte[] byteStr = Base64.encodeBase64(str.getBytes());
					String finalStr = new String(byteStr);
					String url = "http://engineering.apssdc.in/studentRegistration?q:=" + finalStr;
					students.get(i).setUrl(url);
				}
			}
		}
		response.setSuccessful(true);
		response.setResponseObject(students);
		return response;
	}*/

	
}