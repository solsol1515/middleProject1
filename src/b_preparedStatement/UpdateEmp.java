package b_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEmp {

	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 2. 연결 객체 얻어오기
			String ur1 ="jdbc:oracle:thin:@192.168.0.50:1521:xe";
			String user ="scott";
			String pass ="tiger";
			
			Connection con = DriverManager.getConnection(ur1, user, pass);
			System.out.println("디비 연결 성공");
		
		// 입력값
		int sabun 	  = 7369;
		String saname = "아무나";
		int salary	  = 15000;
		
		// 7698사원의 이름과 월급을 변경하세요.
		String sql = "UPDATE emp SET ENAME = ?, SAL = ? WHERE EMPNO = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(3, sabun);
		stmt.setString(1, saname);
		stmt.setInt(2, salary);

		// 5. SQL 전송
		int result = stmt.executeUpdate();
		System.out.println(result +"행을 실행");
		
		// 6. 닫기
		stmt.close();
		con.close();
		
	} catch (Exception e) {
		System.out.println("DB 실패: "+ e);
	}
		
	}

}
