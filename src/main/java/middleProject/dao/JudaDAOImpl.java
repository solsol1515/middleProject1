package middleProject.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import middleProject.domain.LoginVO;

@Repository("judaDAO") // 현재 클래스fmf dao bean으로 등록
public class JudaDAOImpl implements JudaDAO {
	
	private SqlSessionTemplate mybatis;
	
	@Inject // SqlSession 의존관계 주입하기
	SqlSession sqlSession; 
	
	// 로그인
	public Integer selectAllLogin(LoginVO vo) {
		return sqlSession.selectOne("JudaDAO.selectAllLogin", vo);
	}
}
