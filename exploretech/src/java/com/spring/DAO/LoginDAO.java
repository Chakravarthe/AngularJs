package com.spring.DAO;

import com.spring.Model.Login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.andromeda.commons.dao.BaseDAO;

@Repository
public class LoginDAO extends BaseDAO
{

	public Integer checkUser(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		
		Integer userStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);
		
		return userStatus;
	}

	public void saveToLogins(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		sqlSessionTemplate.insert("Login.saveLogins", map);
	}

	public Login getUserDetails(Login login)
	{
		//System.out.println(login.getEmail());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p",login);
		Login details = sqlSessionTemplate.selectOne("Login.getUserDetails", map);
		return details;
		}

	public Integer isUserLoggedIn(Login login)
	{
		Integer loginStatus = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

	      loginStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);
	   return loginStatus;
		
	      /*Boolean status = Boolean.valueOf(StringUtils.isEmpty(login.getRole()));
		if (status.booleanValue())
		{
			loginStatus  = sqlSessionTemplate.selectOne("Login.adminLoggedIn", map);
			System.out.println("-------------------------");
			System.out.println(loginStatus);
			System.out.println("-------------------------");
			         
		}  
		else 
		{
			loginStatus = sqlSessionTemplate.selectOne("Login.principalLoggedIn", map);
			System.out.println("#################################");
			System.out.println(loginStatus);
			System.out.println("########################################");
		}   
		return loginStatus; */
	 
	
	}

	public void deleteLoginLog(String email)
	{
		sqlSessionTemplate.delete("Login.deleteLoginLog", email);
	}

}   