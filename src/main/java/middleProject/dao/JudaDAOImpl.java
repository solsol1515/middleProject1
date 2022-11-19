package middleProject.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import middleProject.domain.LoginVO;

@Repository("judaDAO")
public class JudaDAOImpl implements JudaDAO {
	
	private SqlSessionTemplate mybatis;
	
	public Integer selectAllLogin(LoginVO vo){
		return mybatis.selectOne("JudaDAO.selectAllLogin", vo);
	}
}
