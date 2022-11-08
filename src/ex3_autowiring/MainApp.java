package ex3_autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// [1] Spring 설정 파일 연결 - 객체 생성해줌
		ApplicationContext context = new ClassPathXmlApplicationContext("ex3_autowiring/applicationContext.xml");
		
		MessageBean bean = context.getBean("message" , MessageBean.class);
		bean.sayHello();
	}

}
