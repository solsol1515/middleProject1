package middleProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import middleProject.domain.LoginVO;
import middleProject.service.JudaService;

@Controller
public class JudaController {

	 @RequestMapping("{url}.do") public String userJoin(@PathVariable String url)
	 { System.out.println("확인"); return url; }
	 
	 @Autowired
	 private JudaService judaService;
	 
	 // 로그인 post
	 @RequestMapping("loginSuccess.do")
	 public void selectAllLogin(LoginVO vo, Model m) {
		 m.addAttribute("logSuccess", judaService.selectAllLogin(vo));
		 
		 int result = judaService.selectAllLogin(vo);
		 m.addAttribute("log", result);
		 if(result == 1) {
			 
			 
		 }else {
			 
		 } // end of else() 
	 } // end of selectAllLogin()
	
	 
	
	/*
	 * @RequestMapping("index.do") public void index() {
	 * System.out.println("index.do 실행"); }
	 * 
	 * 
	 * @RequestMapping("intro.do") public void intro() {
	 * System.out.println("intro.do 실행"); }
	 * 
	 * 
	 * @RequestMapping("intro.do") public void goodsList() {
	 * System.out.println("goodsList.do 실행"); }
	 */
	
}
