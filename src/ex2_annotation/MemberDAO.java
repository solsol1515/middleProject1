package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDAO {
		
	// 3. 필드 기반 의존성 주입방식(DI) ******************
	@Autowired
	private MemberBean member; // 멤버변수

		
	// 1. 생성자 함수 (constructor)
//	public MemberDAO() {}
	
//	public MemberDAO(MemberBean member) {
//		this.member = member;
//	} 


	// 2. setter
//	public void setMember(MemberBean member) {
//		this.member = member;
//	}
//		
	public void insert(){ // 확인하기 위한 메소드
		member.output();
		System.out.println("저장하였습니다.");
	} // end of insert
		
}
