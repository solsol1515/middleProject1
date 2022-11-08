package ex2_annotation;

import org.springframework.stereotype.Component;

@Component
public class MemberBean {
	
	// 멤버 변수
	private String name = "홍홍구";
	private int age = 25;
	private String message = "왜 맨날 나는 안되는거냐...?";
	
	// 출력하기 편하도록 함수 생성
	public void output(){
		System.out.println(name + "[" + age + "]" + message);
	}
	
	// 생성자 함수(기본 생성자 함수는 자동으로 만들어지지 않음)
	/*
	 * public MemberBean() { System.out.println("기본 생성자"); }
	 */
	
	
	// 1. constructor 이용
	/*
	 * public MemberBean(String name, int age, String message) { super(); this.name
	 * = name; this.age = age; this.message = message;
	 * System.out.println("인자 있는 생성자"); }
	 */
	

	// 2. setter & getter 이용
	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public int getAge() { return age; } public void
	 * setAge(int age) { this.age = age; } public String getMessage() { return
	 * message; } public void setMessage(String message) { this.message = message; }
	 */
	
}
