package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.commons.util.CryptoUtils;

import com.spring.Model.College;
/*import com.spring.Model.Enroll;*/

@Repository    
public class ServiceDAO extends BaseDAO
{
	                
	
//	public Map<String, Object> getCollegeDetails(Integer districtId)
//	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<College> getDetails =
//				sqlSessionTemplate.selectList("College.getAllDetails", districtId);
//		List<College> getTrainingPrgmDetails =
//				sqlSessionTemplate.selectList("College.getTrainingProgramDetails");
//		List<College> getPrgmDetails = sqlSessionTemplate.selectList("College.getPrgmDetails");
//		map.put("colleges", getDetails);
//		map.put("trainingPrgms", getTrainingPrgmDetails);
//		map.put("prgms", getPrgmDetails);
//		return map;
//	}
//	
	public List<Map<String, Object>> getDistricts()
	{
		return sqlSessionTemplate.selectList("College.getDistricts");
	}
     
	
	public List<Map<String, Object>> getColleges()
	{
		return sqlSessionTemplate.selectList("College.getColleges");
	}
	/*public College getData(String institutioncode)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		College list = sqlSessionTemplate.selectOne("College.getData",institutioncode);
		return list;
	}*/
	public List<Map<String, Object>> getLogins(String institutioncode)
	{
		return sqlSessionTemplate.selectList("College.getLogins", institutioncode);
	}

	public College createLogin(College details)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", details);
		College clgDetails = sqlSessionTemplate.selectOne("College.getCollegeDetails", map);
		details.setPassword(clgDetails.getPwd()); 
		//details.setPwd(CryptoUtils.getMD5Hash(clgDetails.getPwd()));
		map.put("p", details);
		Integer userStatus = sqlSessionTemplate.selectOne("College.checkUser", map);
		if (userStatus == 0)
		{
			sqlSessionTemplate.insert("College.saveLogins", map);
		}  
		/*Integer userId = sqlSessionTemplate.selectOne("College.getUserId", map);
		details.setUserId(userId);*/
		map.put("p", details);
		Integer spocRoleStatus = sqlSessionTemplate.selectOne("College.getRole", map);
		if(spocRoleStatus == 0)
		{
			
			sqlSession.update("College.assignRole", map);
		}
		else     
		{
			details.setUserStatus("User already exists ");
		}
		return details;
	}
	/*public College getDetails(College college)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", college);
		College details = sqlSessionTemplate.selectOne("College.getDetails", map);
		return details;
	}*/
	

	/*public Map<String, Object> getLink(College college)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForStoringBatchDetails = new HashMap<String, Object>();
		college.setProgramIdStr(college.getProgramId().toString());
		map.put("p", college);

		Integer prgmsSyncStatus = sqlSessionTemplate.selectOne("College.checkProgramsSync", map);
		if (prgmsSyncStatus == 0)
		{
			College syncPrgmDetails =
					sqlSessionTemplate.selectOne("College.getProgramNamesForSync", map);
			String message = "Program " + syncPrgmDetails.getProgramName() + " is not present in "
					+ syncPrgmDetails.getTrainingProgramName();

			resultMap.put("message", message);
		}
		else if (prgmsSyncStatus > 0)
		{
			Integer batchId = sqlSessionTemplate.selectOne("College.getTrainingBatchId", map);

			if (batchId == null)
			{
				Integer maxBatchId = sqlSessionTemplate.selectOne("College.getMaxBatchId");
				if (maxBatchId == null)
				{
					maxBatchId = 0;
				}
				Integer newBatchId = maxBatchId + 1;

				Integer trainingProgramId = college.getTrainingProgramId();

				Programs startAndEndDates =
						sqlSessionTemplate.selectOne("College.getProgramDates", trainingProgramId);
				Programs programsforBatcheIds = new Programs();
				programsforBatcheIds.setCollegeId(college.getCollegeId());
				programsforBatcheIds.setTrainingBatchId(newBatchId);
				programsforBatcheIds.setTrainingProgramId(trainingProgramId);
				programsforBatcheIds.setStartDate(startAndEndDates.getStartDate());
				programsforBatcheIds.setEndDate(startAndEndDates.getEndDate());
				programsforBatcheIds.setProgramId(college.getProgramId());

				mapForStoringBatchDetails.put("p1", programsforBatcheIds);

				sqlSessionTemplate.insert("College.insertNewBatchId", mapForStoringBatchDetails);

				batchId = newBatchId;
			}

			resultMap.put("newBatchId", batchId);
		}
		return resultMap;
	}

	public List<Student> getStudentDetails(String registrationId)
	{
		List<Student> studentDetails =
				sqlSessionTemplate.selectList("College.getStudentDetailsForShift", registrationId);
		return studentDetails;
	}

	public Boolean changeStudentCourse(Student student)
	{
		Boolean status = false;
		Integer batchId = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", student);
		Student studentClgDetails =
				sqlSessionTemplate.selectOne("College.getStudentClgDetails", map);
		student.setCollegeName(studentClgDetails.getCollegeName());
		student.setDistrictId(studentClgDetails.getDistrictId());
		map.put("p", student);
		int batchCount = sqlSessionTemplate.selectOne("College.checkBatches", map);
		
		 * String year = sqlSessionTemplate.selectOne("College.getGraduationYear", map);
		 * student.setGraduationYear(year);
		 
		if (batchCount == 0)
		{
			// System.out.println("--> No Batch Id");
			sqlSessionTemplate.insert("College.insertBatch", map);
			batchId = sqlSessionTemplate.selectOne("College.getBatchId", map);
		}
		else
		{
			// System.out.println("--> Batch Exists");
			batchId = sqlSessionTemplate.selectOne("College.getBatchId", map);
			Integer studentsCount = sqlSessionTemplate.selectOne("College.getBatchCount", batchId);
			if (studentsCount >= 30)
			{
				sqlSessionTemplate.insert("College.insertBatch", map);
				batchId = sqlSessionTemplate.selectOne("College.getBatchId", map);
			}
		}
		student.setNewTrainingBatchId(batchId);
		map.put("p", student);
		sqlSessionTemplate.update("College.updateBatchInReg", map);
		sqlSessionTemplate.update("College.updateStudentBatchIdInBatchStuTable", map);
		sqlSessionTemplate.insert("College.savetoCoursesLog", map);
		status = true;
		return status;
	}

	public List<College> getTrainingPrograms(College details)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", details);
		List<College> programs = sqlSessionTemplate.selectList("College.getTrainingPrograms", map);
		return programs;
	}
	
	public List<College> getTrainingPrograms1(College details)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", details);
		List<College> programs = sqlSessionTemplate.selectList("College.getTrainingPrograms1", map);
		return programs;
	}

	public List<College> getProgramsDetails(Integer trainingProgramId)
	{
		List<College> programs =
				sqlSessionTemplate.selectList("College.getProgramsDetails", trainingProgramId);
		return programs;
	}

	public Integer getBasicDetails(Student student)
	{
		String aadhaar = student.getAadhaar();
		Integer status = sqlSessionTemplate.selectOne("College.getBasicDetails", aadhaar);
		return status;
	}

	public Map<String, Object> getProgramNames(Student student)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", student);
		Student prevCourseDetails =
				sqlSessionTemplate.selectOne("College.getPrevCourseDetails", map);
		Student courseDetails = sqlSessionTemplate.selectOne("College.getCourseDetails", map);
		Map<String, Object> coursesMap = new HashMap<String, Object>();
		coursesMap.put("prevProgramName", prevCourseDetails.getPrevTrainingProgramName());
		coursesMap.put("prevCourseName", prevCourseDetails.getPrevProgramName());
		coursesMap.put("programName", courseDetails.getTrainingProgramName());
		coursesMap.put("courseName", courseDetails.getProgramName());
		
		 * System.out.println("--> Courses details"); System.out.println(coursesMap);
		 
		return coursesMap;
	}*/

	

	/*public List<Student> getActivePrograms(Integer collegeId)
	{
		return sqlSessionTemplate.selectList("College.getActivePrograms", collegeId);
	}

	public List<Student> getCourses(Integer programId)
	{
		return sqlSessionTemplate.selectList("College.getCourses", programId);
	}

	public List<Student> getStudents(Student student)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", student);
		return sqlSessionTemplate.selectList("College.getActiveStudents", map);
	}

	public String getProgramType(Student student)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", student);
		return sqlSessionTemplate.selectOne("College.getProgramType", map);
	}*/

	
}