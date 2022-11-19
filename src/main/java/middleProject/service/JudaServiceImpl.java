package middleProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleProject.dao.JudaDAO;
import middleProject.domain.LoginVO;

@Service("judaService")
public class JudaServiceImpl implements JudaService{

	@Autowired
	private JudaDAO judaDAO;
	
	//	아이디 중복 체크 sql + 로그인 기능 sql
	public Integer selectAllLogin(LoginVO vo){
		return judaDAO.selectAllLogin(vo);
	} // end of selectAllLogin()
	
}
