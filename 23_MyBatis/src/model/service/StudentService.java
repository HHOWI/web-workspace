package model.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {

	public List<StudentVO> search(String word) {
		SqlSession sqlSession = Template.getSqlSession();
		List<StudentVO> list = StudentDAO.getInstance().search(sqlSession, word);
		sqlSession.close();
		
		return list;
	}

}
