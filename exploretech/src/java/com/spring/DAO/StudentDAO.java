package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Model.Student;

@Repository
public class StudentDAO {
	@Autowired 
	private SqlSessionFactory sqlSessionFactory;
	public List<Student> getAll(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
			List<Student> studentdetails=sqlSession.selectList("Student.getAll",email);
			sqlSession.close();
			return studentdetails;
	}
	
	
}   
