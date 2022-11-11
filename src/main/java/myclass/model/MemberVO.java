package myclass.model;

public class MemberVO {
	
	private String 	id;
	private String 	name;
	private int 		age;
	
	private boolean state;
	
	// setter & getter
	public boolean isState() { // boolean형의 getter는 is 사용 (true or false의 값이기때문에)
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	// setter & getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
	
	
}
