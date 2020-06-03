package com.spring.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import javax.persistence.PersistenceException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.Model.AddStudent;

@Repository
public class AddStudentDAO extends BaseDAO{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	public AddStudent getYear()
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AddStudent year=sqlSession.selectOne("AddStudent.getYear");
		sqlSession.close();
		return year;
		
	}
	
	public Map<String, Object> saveDetails(List<AddStudent> student, String ipAddress)
	{
		Map<String, Object> maps = new HashMap<String, Object>();

		AddStudent addStudent1 = new AddStudent();
		addStudent1
				.setRole(((AddStudent) student.get(0)).getRole());
		addStudent1
				.setFilePath(((AddStudent) student.get(0)).getFilePath());
		addStudent1
				.setFileExtension(((AddStudent) student.get(0)).getFileExtension());
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("p1", addStudent1);
	
		sqlSessionTemplate.insert("AddStudent.saveFileUploadDetails", map1);
		try
		{	
			if (student.size() > 0)
			{
				Iterator<AddStudent> i = student.iterator();
				while (i.hasNext())
				{
					AddStudent addStudent =
							(AddStudent) i.next();
					addStudent.setIpAddress(ipAddress);
					maps.put("p", addStudent);
					                                
						System.out.println("==============================>"+maps);
						this.sqlSessionTemplate.insert("AddStudent.saveIntake", maps);
						this.sqlSessionTemplate.insert("AddStudent.saveDetails", maps);
						this.sqlSessionTemplate.update("AddStudent.updateDetails", maps);
							
						
					
				}
			}       
		}
		catch (Throwable t)
		{
			System.out.println("Excepction occured during updateBatch: " + t);

			throw new PersistenceException(t);
		}
		return map1;
		}

	/*public void add(AddStudent addStudent) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", addStudent);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("AddStudent.Insert", params);                    
		sqlSession.close();                             
	}*/

	public List<AddStudent> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AddStudent> condetails=sqlSession.selectList("AddStudent.getAll");
		sqlSession.close();
		return condetails;  
	}

	public void remove(String firstname)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("AddStudent.deleteData",firstname);
		sqlSession.close();
	}

	public AddStudent getById(String firstname)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AddStudent singlecondetails=sqlSession.selectOne("AddStudent.getById",firstname);
		sqlSession.close();
		return singlecondetails;
		
	}

	public void updateData(AddStudent addStudent)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", addStudent);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AddStudent.updateData",params);
		sqlSession.close();
	}

}
