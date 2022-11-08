package ex1_xml2_ref;

public class MemberDAO {

		private MemberBean member; // 멤버변수

		
		// 생성자 함수 (constructor)
		public MemberDAO() {}
	
		public MemberDAO(MemberBean member) {
			this.member = member;
		} 


		// setter
		public void setMember(MemberBean member) {
			this.member = member;
		}
		
		public void insert(){ // 확인하기 위한 메소드
			member.output();
			System.out.println("저장하였습니다.");
		} // end of insert
		
}
