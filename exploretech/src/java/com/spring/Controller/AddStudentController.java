package com.spring.Controller;
import java.io.File;
import java.io.FileOutputStream;
/*import java.io.UnsupportedEncodingException;*/
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
/*import java.security.NoSuchAlgorithmException;*/
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import commons.util.Base64;
import com.spring.Model.FileModel;
import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;
import com.spring.Model.AddStudent;
import com.spring.Service.AddStudentService;

@RestController
@RequestMapping("/AddStudent")
public class AddStudentController {     
	
	String file = null;
	Response response = new Response();
	
	@Autowired                
	private AddStudentService addStudentService;                                                            
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getYear", method = { RequestMethod.POST, RequestMethod.GET })
     public Response getYear() 
	{
		return addStudentService.getYear();
	
	}
	
	
	@ResponseBody
	@RequestMapping(value = { "saveDetails" }, method = { RequestMethod.POST })
	public Response saveDetails(@RequestBody List<AddStudent> student,
			HttpServletRequest httpServletRequest)
	{
		String clientAddress = HttpUtils.getClientAddress(httpServletRequest);
		String proxyAddress = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress =
				"Client Address: " + clientAddress + "Client Proxy Address: " + proxyAddress;
		List<String> pathsList = new ArrayList<String>();
		// StudentRegistrationModal studentRegistrationModal =(StudentRegistrationModal)
		// student.get(0);
		return this.addStudentService.saveDetails(student, ipAddress, pathsList);
	}

	@ResponseBody
	@RequestMapping(value = { "/upload" },
			method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public Response handleFileUpload(@RequestBody FileModel fileModel)
	{
		this.response.setSuccessful(false);
		FileOutputStream fos = null;
		String file = null;
		try
		{
			String imageValue =fileModel.getBase64String();
			byte[] imageByteArray = decodeImage(imageValue);
			

			// Integer folderName = fileModel.getCollegeId();
			String baseDir =
					System.getProperty("catalina.base") + "/webapps/uploads/EOIStudentsData";
			File dir = new File(baseDir);
			if (!Files.isDirectory(Paths.get(baseDir)))
			{
				dir.mkdirs();
			}
			String random = UUID.randomUUID().toString();
			/*System.out.println("==================================================" + baseDir);*/
			fos = new FileOutputStream(baseDir + "/" +random+fileModel.getFileName());
			/*System.out.println(fos);*/
			file = "/uploads/EOIStudentsData" + "/" +random+ fileModel.getFileName();

			fos.write(imageByteArray);
			fos.close();
			// File f = new File(fileModel.getName());
			fileModel.setName(file);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		this.response.setSuccessful(true);
		this.response.setResponseObject(fileModel);
		return this.response;
	}
	public static byte[] decodeImage(String imageValue)
	{
		

		return Base64.decode(imageValue);
	}


	
	/*@ResponseBody
	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public Response add(@RequestBody AddStudent addStudent)
	{
		return addStudentService.add(addStudent);
	}*/
	
	@ResponseBody
	@RequestMapping(value = "getAll", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAll()
	{
		return addStudentService.getAll();
	}                                               
	
	@ResponseBody                                              
	@RequestMapping(value = "removeData", method = { RequestMethod.POST })
	public Response remove(@RequestBody String firstname)
	{
		return addStudentService.remove(firstname);
	}
	
	@ResponseBody
	@RequestMapping(value = "getById", method = { RequestMethod.POST })
	public Response getById(@RequestBody String firstname)
	{
		return addStudentService.getById(firstname);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateData", method = { RequestMethod.POST })
	public Response updateData(@RequestBody AddStudent addStudent)
	{
		return addStudentService.updateData(addStudent);
	}
}
