package ex1_xml3_list;

public class MemberBean {
	
	private String name;
	private int age;
	private String message;
	
	// 출력하기 편하도록 함수 생성
	public void output(){
		System.out.println(name + "[" + age + "]" + message);
	}
	
	// constructor
	public MemberBean() {
		System.out.println("기본 생성자");
	}
	
	
	// 생성자 함수(기본 생성자 함수는 자동으로 만들어지지 않음)
	public MemberBean(String name, int age, String message) {
		super();
		this.name = name;
		this.age = age;
		this.message = message;
		System.out.println("인자 있는 생성자");
	}
	

	// setter & getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
