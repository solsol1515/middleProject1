package middleProject.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleProject.dao.JudaDAO;
import middleProject.domain.LoginVO;

@Service("judaService")
public class JudaServiceImpl implements JudaService{

	@Autowired
	private JudaDAO judaDAO;
	
	//	아이디 중복 체크 sql + 로그인 기능 sql
	public Integer selectAllLogin(LoginVO vo) {
		return judaDAO.selectAllLogin(vo);
	} // end of selectAllLogin()

	
	@Override
	public Integer selectAllLogin(LoginVO vo, HttpSession session) {
		Integer name = judaDAO.selectAllLogin(vo);
		if(name != null) { // 세션 변수 저장
			session.setAttribute("id", vo.getMember_id());
			session.setAttribute("name", name);
		}
		return name;
	}

	
	@Override
	public void logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
	}
	
}
