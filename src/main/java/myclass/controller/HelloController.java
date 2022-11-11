package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("요청 받음");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "즐거운 하루...가 맞아? 아니");
		mv.addObject("data", "제발 살려주세요 plz");
		
		// WEB-INF/views/ + secret + .jsp
		mv.setViewName("secret");
		return mv;
	}
}
