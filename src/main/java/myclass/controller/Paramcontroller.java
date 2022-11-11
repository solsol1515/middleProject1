package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myclass.model.MemberVO;

@Controller
public class Paramcontroller {
	
	@RequestMapping({"param.do", "paramForm.do"})
	public ModelAndView test(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("param");
		return mv;
	}
	
}
