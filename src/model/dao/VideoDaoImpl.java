package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.VideoVO;

public class VideoDaoImpl implements VideoDao{
		
		final static String DRIVER   = "oracle.jdbc.driver.OracleDriver";
		final static String URL      = "jdbc:oracle:thin:@192.168.0.50:1521:xe";
		final static String USER     = "project";
		final static String PASS     = "1234";

		public VideoDaoImpl() throws Exception{
		// 1. 드라이버로딩
		Class.forName(DRIVER);
		
	}
	
	public void insertVideo(VideoVO vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		
		// 3. sql 문장 만들기
		String sql = "INSERT INTO VIDEO (video_No, genre, title, director, actor, exp) " // 데이터 넣을 컬럼명 입력
				+ " VALUES (project_seq.nextval, ?, ?, ?, ?, ?)";						 // 해당 시퀀스 값 증가
		
		// 4. sql 전송객체 (PreparedStatement)		
		ps = con.prepareStatement(sql);
			ps.setString(1, vo.getGenre());
			ps.setString(2, vo.getVideoName());
			ps.setString(3, vo.getDirector());
			ps.setString(4, vo.getActor());
			ps.setString(5, vo.getExp());
			
		// 5. sql 전송
			for(int i=0; i<count; i++) {
				ps.executeUpdate();
			} // end of for
		} finally {
		// 6. 닫기
			ps.close();
			con.close();
		}
	} // end of insertVideo()

	public ArrayList selectVideo() throws Exception {
		ArrayList data = new ArrayList(); // 저장할 데이터가 여러종류라서 ArrayList 사용
		
		// 2. 연결 객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		 
		// 3. sql 문장 
		String sql = "SELECT VIDEO_NO, TITLE, DIRECTOR, ACTOR FROM VIDEO ";
		
		// 4. 전송 객체 
			ps = con.prepareStatement(sql);
			
		// 5. 전송
		ResultSet rs = ps.executeQuery(); // rs로 데이터 받음.
		
		while(rs.next()) { // 선택한 요소의 다음 요소를 선택
			
			ArrayList temp = new ArrayList(); 
			
			temp.add(rs.getInt("video_no"));
			temp.add(rs.getString("title"));
			temp.add(rs.getString("director"));
			temp.add(rs.getString("actor"));
			
			data.add(temp); // data에 temp 데이터 한꺼번에 담기 
		}
		
		return data;
		
		} finally {
			// 6. 닫기
				ps.close();
				con.close();
		  }
	} // end of selectVideo()
	

}
