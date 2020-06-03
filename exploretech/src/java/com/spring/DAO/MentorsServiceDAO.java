package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.commons.util.CryptoUtils;

import com.spring.Model.MentorsModel;

@Repository   
public class MentorsServiceDAO extends BaseDAO{
	public MentorsModel createLogin(MentorsModel details)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", details);
		sqlSessionTemplate.insert("MentorsModel.saveDetails", map);
		map.put("p", details);
		MentorsModel clgDetails = sqlSessionTemplate.selectOne("MentorsModel.getDetails", map);
		details.setPassword(clgDetails.getPwd()); 
		details.setPwd(CryptoUtils.getMD5Hash(clgDetails.getPwd()));
		map.put("p", details);
		Integer userStatus = sqlSessionTemplate.selectOne("MentorsModel.checkUser", map);
		if (userStatus == 0)
		{  
			sqlSessionTemplate.insert("MentorsModel.saveLogins", map);
		}  
		/*Integer userId = sqlSessionTemplate.selectOne("MentorsModel.getUserId", map);
		details.setUserId(userId);
		map.put("p", details);   
		Integer spocRoleStatus = sqlSessionTemplate.selectOne("MentorsModel.getRole", map);
		if(spocRoleStatus == 0)
		{
			
			sqlSession.update("MentorsModel.assignRole", map);
		}      
		else     
		{
			details.setUserStatus("User already exists in " + clgDetails.getMentorsname());
		}*/
		return details;
	}
}        
