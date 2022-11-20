package middleProject.service;

import javax.servlet.http.HttpSession;

import middleProject.domain.LoginVO;

public interface JudaService {

	// 로그인
	public Integer selectAllLogin(LoginVO vo, HttpSession session) {
		return null;
	}
	
	// 로그아웃?
	public void logout (HttpSession session); 
	
}
