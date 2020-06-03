package com.spring.DAO;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Model.Register;

@Repository
public class RegisterDAO {
	@Autowired 
	private SqlSessionFactory sqlSessionFactory;
	public void add(Register regModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p", regModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Register register = sqlSession.selectOne("Register.Count", params);
		regModel.count = register.count;   
		sqlSession.insert("Register.Insert", params);
		sqlSession.update("Register.updateData",params);    
		sqlSession.close();
	}
	
	public Register getById(String email)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Register user=sqlSession.selectOne("Register.getById", email);
		sqlSession.close();
		return user;
		
	}
	public void updateProfile(Register register)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", register);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Register.updateProfile",params);
		sqlSession.close();
	}
	
}
