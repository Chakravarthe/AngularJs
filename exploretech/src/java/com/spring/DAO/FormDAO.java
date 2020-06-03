package com.spring.DAO;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Model.Form;

@Repository
public class FormDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add(Form form) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", form);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Form.Insert", params);
		sqlSession.close();
	}
	/*public List<Map<String, Object>> getCourses()
	{
	    
		List<Map<String, Object>> list = sqlSessionTemplate.selectList("Library.getCourses");
		return list;
	}
	public List<Form> getAll(String institutioncode,String role) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("institutioncode", institutioncode);
		params.put("role", role);
			List<Form> librarydetails=sqlSession.selectList("Library.getAll",params);
			sqlSession.close();
			return librarydetails;
			}else if(role.equals("inspection1")) {
				List<Library> librarydetails=sqlSession.selectList("Library.getAllIns1",collegeid);
				sqlSession.close();
				return librarydetails;
			}else if(role.equals("inspection2")) {
				List<Library> librarydetails=sqlSession.selectList("Library.getAllIns2",collegeid);
				sqlSession.close();
				return librarydetails;   
			}else if(role.equals("inspection3")){
				List<Library> librarydetails=sqlSession.selectList("Library.getAllIns3",collegeid);
				sqlSession.close();
				return librarydetails;   
			}else if(role.equals("inspection4")){
				List<Library> librarydetails=sqlSession.selectList("Library.getAllIns4",collegeid);
				sqlSession.close();
				return librarydetails;
			}else {   
				List<Library> librarydetails=sqlSession.selectList("Library.getAllIns5",collegeid);
				sqlSession.close();
				return librarydetails;           
			}
		List<Library> librarydetails=sqlSession.selectList("Library.getAll");
		sqlSession.close();
		return librarydetails;
	}

	public void remove(String lib)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("Library.deleteData",lib);
		sqlSession.close();
	}

	public Form getById(Form library)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", library);
		params.put("institutioncode", library.getInstitutioncode());
		params.put("branchname", library.getBranchname());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Form librarydetails = sqlSessionTemplate.selectOne("Library.getById",params);
		sqlSession.close();
		return librarydetails;             
		
	}
	    

	public List<Form> getBranches(String role,String institutioncode)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		Form lib=new Form();
		lib.role= role;
		lib.institutioncode= institutioncode;
		params.put("p", lib);
		params.put("institutioncode", library.getInstitutioncode());
		params.put("branchname", library.getBranchname());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Form> librarydetails;
		librarydetails = sqlSessionTemplate.selectList("Library.getBranches",params);
		sqlSession.close();
		return librarydetails;
		
	}


	public void updateData(Form lib)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", lib);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Library.updateData",params);
		sqlSession.close();
	}*/

}
