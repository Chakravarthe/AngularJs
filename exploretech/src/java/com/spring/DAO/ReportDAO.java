package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.Report;

@Repository      
public class ReportDAO extends BaseDAO {
	
	
	public Report getAll(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
			Report studentdetails=sqlSession.selectOne("Report.getAll",email);
			sqlSession.close();
			return studentdetails;  
	}
	
	  
	public List<Report> getCourses(String branchid)
	{
		List<Report> data = sqlSessionTemplate.selectList("Report.getCourses",branchid);
		return  data;
	}     

	
	public List<Report> getBranches(String email)
	{
		
		List<Report> data = sqlSessionTemplate.selectList("Report.getBranches",email);
		return  data;
	}
	
	
}
