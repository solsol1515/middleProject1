package ex3_autowiring;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanImpl implements MessageBean{

	private String name;
	private String message;
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Autowired
	@Qualifier("outputer2") // 빈 DI 정확하게 해줌
	//@Resource(name="outputer2")
	private Outputer out; // DI
	
	@Override
	public void sayHello() {
		System.out.println(name + "님께: " + message);
		try {
			out.writeMessage(name + "님께: " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of sayHello
	
}
