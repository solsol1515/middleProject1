package ex2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// [1] Spring 설정 파일 연결 - 객체 생성해줌
		ApplicationContext context = new ClassPathXmlApplicationContext("ex2_annotation/applicationContext.xml");
		
		MemberDAO dao = context.getBean("dao", MemberDAO.class);
		// MemberDAO → memberDAO
		dao.insert();
	}

}
