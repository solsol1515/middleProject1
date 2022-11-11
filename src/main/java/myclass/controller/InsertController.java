package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("review/")
public class InsertController {

	@RequestMapping("insert.do") // insert.do요청 시 실행
	public String test(Model m) {
		// ************************************
		// return "select"; 뷰페이지만 연결되어 데이터 넘어오지 않음 !!!
		// ************************************
		// 리다이렉팅
		return "redirect:select.do"; // DB까지 같이 받아오기 위해서 반드시 "리다이렉트" 붙이기 
	}
	
	
	@RequestMapping("select.do") // select.do요청 시 실행
	public void test2(Model m) {
		m.addAttribute("info", "DB에서 넘어온 값");
	}
}
