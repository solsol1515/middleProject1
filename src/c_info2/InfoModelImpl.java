package c_info2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoModelImpl implements infoModel {

   //final이 붙으면 대문자로 
   final static String DRIVER   = "oracle.jdbc.driver.OracleDriver";
   final static String URL      = "jdbc:oracle:thin:@192.168.0.50:1521:xe";
   final static String USER     = "scott";
   final static String PASS     = "tiger";
   
   
   public InfoModelImpl() throws ClassNotFoundException {
      // 1. 드라이버 로드
      Class.forName(DRIVER);
      System.out.println("드라이버로딩 성공");
   }
   
   /*
    * 사용자 입력 값을 받아서 DB에 저장하는 역할
    */
   
   @Override
public void insertInfo(InfoVO vo) throws SQLException{
	  
	   // 2. 연결 객체 얻어오기
	   Connection con 		= null;
	   PreparedStatement ps = null;
	   try {
	   con = DriverManager.getConnection(URL, USER, PASS);
	   
	   // 3. sql 문장 (#)
	   String sql = "INSERT INTO info_tab(name, jumin, tel, gender, age, home) " // 데이터베이스 컬럼명
			   + " VALUES(?, ?, ?, ?, ?, ?)";
	   
	   // 4. 전송 객체
	   ps = con.prepareStatement(sql);
	   //? 세팅 - #
	   ps.setString(1, vo.getName());
	   ps.setString(2, vo.getId());
	   ps.setString(3, vo.getTel());
	   ps.setString(4, vo.getGender());
	   ps.setInt   (5, vo.getAge());
	   ps.setString(6, vo.getHome());
	   
	   // 5. 전송
	   ps.executeUpdate();	// insert
	   
	   }finally {
	   // 6. 닫기 (사용순서와 반대로 닫기)
		   ps.close();
		   con.close();
	   }
   }// end of insertInfo()
   
   		@Override
		public ArrayList<InfoVO> selectAll() throws SQLException{
   			// 2. 연결 객체 얻어오기
   			Connection con 		 = null;
   			PreparedStatement ps = null;
   			ResultSet rs 		 = null;
   			try {
   			   con = DriverManager.getConnection(URL, USER, PASS);
   			
   			   // 3. SQL 문장
   			   String sql = "SELECT * FROM info_tab";
   		
   			   // 4. 전송 객체 얻어오기
   			   ps = con.prepareStatement(sql);
   	
   			   // 5. 전송
   			   rs = ps.executeQuery();
   			
   			   ArrayList<InfoVO>list = new ArrayList<InfoVO>();
   			   while(rs.next()) {
   				   InfoVO vo = new InfoVO();
   				   vo.setName(rs.getString("NAME"));
   				   vo.setId(rs.getString("JUMIN"));
   				   vo.setTel(rs.getString("TEL"));
   				   vo.setAge(rs.getInt("AGE"));
   				   vo.setGender(rs.getString("GENDER"));
   				   vo.setHome(rs.getString("HOME"));
   					
   		   			list.add(vo);
   			   }
   			   return list;
   			}finally {
   				// 6. 닫기
   				rs.close();
   				ps.close();
   				con.close();
   			} 
   		} // end of selectAll()

		// 전화번호 검색
		public InfoVO selectByTel(String tel) throws SQLException {
			// 2. 연결 객체 얻어오기
			   Connection con 		= null;
			   PreparedStatement ps = null;
			   InfoVO vo 			= new InfoVO();
			   try {
				   con = DriverManager.getConnection(URL, USER, PASS);
				   // 3. sql 문장
				   String sql = "SELECT * FROM info_tab WHERE tel=?"; // 전화번호 변수?
				   
				   // 4. 전송 객체 얻어오기
				   ps = con.prepareStatement(sql);
				   ps.setString(1, tel); // 물음표 전화번호 값 얻어오기
				   
				   // 5. 전송
				   ResultSet rs = ps.executeQuery(); // select 문장이라 query 사용 
				   if(rs.next()) {
					   vo.setName(rs.getString("NAME"));
					   vo.setId(rs.getString("JUMIN"));
					   vo.setTel(rs.getString("TEL"));
					   vo.setAge(rs.getInt("AGE"));
					   vo.setGender(rs.getString("GENDER"));
					   vo.setHome(rs.getString("HOME"));
				   }
			   }finally {
	   				// 6. 닫기
	   				ps.close();
	   				con.close();
			   } 
			   return vo;
		} // end of selectByTel()

		/*
		 * 메소드명 	: delete
		 * 인자 	 	: 전화번호 
		 * 리턴 값	: 삭제한 행 수
		 * 역할		: 전화번호를 넘겨받아 해당 전화번호의 레코드를 삭제 
		 */
		
		public int delete(String tel) throws SQLException { // int로 받는 이유는 delete 0 or 1값으로 리턴받기때문에 
			// 2. 연결 객체 얻어오기
			   Connection con 		= null;
			   PreparedStatement ps = null;
			   int result 			= 0;
			   try {
				   con = DriverManager.getConnection(URL, USER, PASS);
				   
			// 3. sql 문장
			   String sql = "DELETE FROM info_tab WHERE tel=?"; 
			
			// 4. 전송 객체 얻어오기
			   ps = con.prepareStatement(sql);
			   ps.setString(1, tel); // 물음표 전화번호 값 얻어오기
			   
			// 5. 전송
			   result = ps.executeUpdate(); // delete 문장이라 executeUpdate사용 
			   
			   }finally {
	   				// 6. 닫기
	   				ps.close();
	   				con.close();
			   } 
			   return result;
			   
		} // end of delete()

			public void modify(InfoVO vo) throws SQLException {
				// 2. 연결 객체 얻어오기
				   Connection con 		= null;
				   PreparedStatement ps = null;
				  
				   try {
					   con = DriverManager.getConnection(URL, USER, PASS);
					   
				// 3. sql 문장
				   String sql = "UPDATE info_tab SET name =?, jumin = ?, gender = ?, age = ?, home = ? WHERE tel = ?"; 
				
				// 4. 전송 객체 얻어오기
				   ps = con.prepareStatement(sql);
				   ps.setString(1, vo.getName()); // 물음표 전화번호 값 얻어오기
				   ps.setString(2, vo.getId());
				   ps.setString(3, vo.getGender());
				   ps.setString(4, Integer.toString(vo.getAge()));
				   ps.setString(5, vo.getHome());
				   ps.setString(6, vo.getTel());
				   
				// 5. 전송
				   ps.executeUpdate(); // delete 문장이라 executeUpdate사용 
				   
				   }finally {
		   				// 6. 닫기
		   				ps.close();
		   				con.close();
				   } 
				   
			} // end of modify()
		
	} // end of class InfoModelImpl
