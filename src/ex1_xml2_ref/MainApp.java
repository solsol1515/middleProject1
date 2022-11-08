package ex1_xml2_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		// [1] Spring 설정 파일 연결 - 객체 생성해줌
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml2_ref/applicationContext.xml");
		
		// [2] 빈 가져오기
//		MemberBean bean = context.getBean("member", MemberBean.class); // 형 변환
//		bean.output();
//		
//		MemberBean bean2 = context.getBean("member2", MemberBean.class); // 형 변환
//		bean2.output();
		
		MemberDAO dao1 = context.getBean("dao", MemberDAO.class);
		dao1.insert();
		
		MemberDAO dao2 = context.getBean("dao2", MemberDAO.class);
		dao2.insert();
		
	}

}
