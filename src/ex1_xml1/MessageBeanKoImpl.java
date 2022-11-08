package ex1_xml1;

public class MessageBeanKoImpl implements MessageBean{
	
	public MessageBeanKoImpl() {
		System.out.println("MessageBeanKoImpl 객체 생성");
	}
	
	public void sayHello(String name) {
		System.out.println(name+"님 안녕하세요");
	}
}
