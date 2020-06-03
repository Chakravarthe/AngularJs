package com.spring.DAO;

import java.util.List;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.Program;

@Repository    
public class ProgramDAO extends BaseDAO {
	

	public List<Program> getBranches()
	{
		
		List<Program> data = sqlSessionTemplate.selectList("Program.getBranches");
		return  data;
	}
	
	
	public void add(Program lib) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", lib);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Program.Insert", params);
		sqlSession.close();
	}
	
	
}
