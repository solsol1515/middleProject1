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
	
	/*
	 * 메소드명	: insertVideo
	 * 인자		: (VideoVO, int) 장르, 제목, 감독, 배우, 설명, 다중개수
	 * 리턴값		: 번호, 장르, 제목, 감독, 배우, 설명 
	 * 역할		: 비디오 정보 등록하기
	 */
		
	public void insertVideo(VideoVO vo, int count) throws Exception{
		// (2) Connection 연결객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		
		// (3) sql 문장 만들기
		String sql = "INSERT INTO VIDEO (video_No, genre, title, director, actor, exp) " // 데이터 넣을 컬럼명 입력
				+ " VALUES (project_seq.nextval, ?, ?, ?, ?, ?)";						 // 해당 시퀀스 값 증가
		
		// (4) sql 전송객체 (PreparedStatement)
		ps = con.prepareStatement(sql);
			ps.setString(1, vo.getGenre());
			ps.setString(2, vo.getVideoName());
			ps.setString(3, vo.getDirector());
			ps.setString(4, vo.getActor());
			ps.setString(5, vo.getExp());
			
		// (5) sql 전송
			for(int i=0; i<count; i++) {
				ps.executeUpdate();
			} // end of for
		} finally {
			
		// (6) 닫기
			ps.close();
			con.close();
		}
	} // end of insertVideo()

	/*
	 * 메소드명	: selectVideo
	 * 인자		: (int, String) 제목, 감독
	 * 리턴값		: (ArrayList) 등록된 비디오 정보(비디오 번호, 제목, 감독, 배우)
	 * 역할		: 비디오 정보 조회하기
	 */
	
	public ArrayList selectVideo(int idx, String word) throws Exception {
		ArrayList data = new ArrayList(); // 저장할 데이터가 여러종류라서 ArrayList 사용
		
		// 2. 연결 객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		 
		// 3. sql 문장 
		String []colNames = {"TITLE", "DIRECTOR"};
		String sql = "SELECT VIDEO_NO, TITLE, DIRECTOR, ACTOR FROM VIDEO  "
				+ "  WHERE  " + colNames[idx]+ "  LIKE '%"+ word +"%'"; 
		// tfVideoSearch에 입력된 값인 word를 포함한 문자열을 검색해줌
		
		System.out.println(sql);
		
		// (4) 전송 객체 
			ps = con.prepareStatement(sql);

		// (5) 전송
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
	
	/*
	 * 메소드명	: selectByVnum
	 * 인자		: (int) 비디오 번호
	 * 리턴값		: (VideoVO) 비디오 정보(번호, 제목, 감독, 배우) 
	 * 역할		: 비디오 번호를 넘겨받아 해당 비디오 번호의 비디오 정보를 리턴
	 */
	
	public VideoVO selectByVnum(int vnum) throws Exception{
		
		VideoVO vo = new VideoVO();
		Connection con 		 = null;
		PreparedStatement ps = null;

		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		 
		String sql = "SELECT * FROM VIDEO WHERE video_no = ?";
		
		ps = con.prepareStatement(sql);
			ps.setInt(1, vnum);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) { 
			
			vo.setVideoNo(rs.getInt("video_no"));
			vo.setGenre(rs.getString("genre"));
			vo.setVideoName(rs.getString("title"));
			vo.setDirector(rs.getString("director"));
			vo.setActor(rs.getString("actor"));
			vo.setExp(rs.getString("exp"));
			
		}
		} finally {
			ps.close();
			con.close();
		}
		return vo;
	} // end of selectByVnum()

	/*
	 * 메소드명	: modifyVideo
	 * 인자		: (VideoVO) 비디오 번호
	 * 리턴값		: (int)제목, 감독, 배우, 설명 
	 * 역할		: 등록된 비디오 정보 수정
	 */
	
	// 정보 수정하기
	public int modifyVideo(VideoVO vo) throws Exception {
		
		// (2) connect 연결 객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		
		// (3) sql 문장  
		String sql = "UPDATE VIDEO SET genre =?,  title = ?, " 
				   + " director = ?, actor = ?, exp = ? "
				   + " WHERE video_no = ?";

		ps = con.prepareStatement(sql);
			ps.setString(1, vo.getGenre());
			ps.setString(2, vo.getVideoName());
			ps.setString(3, vo.getDirector());
			ps.setString(4, vo.getActor());
			ps.setString(5, vo.getExp());
			ps.setInt(6, vo.getVideoNo());
		
			int result = ps.executeUpdate();
			return result;

		}finally{
			ps.close();
			con.close();
		} // end of finally
		
	} // end of modifyVideo()
	
	/*
	 * 메소드명	: deleteVideo
	 * 인자		: (int) 비디오 번호
	 * 리턴값		: (int) 제목, 감독, 배우, 설명 
	 * 역할		: 등록된 비디오 정보 삭제
	 */
	
	// 정보 삭제하기
	public int deleteVideo(int vnum) throws Exception {
		
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
		 con = DriverManager.getConnection(URL, USER, PASS);
		 
		String sql = "DELETE  FROM VIDEO WHERE video_no = ?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, vnum);
		
		ps.executeUpdate();
		
		return 0;
		}finally {
			ps.close();
			con.close();
		}

	} // end of deleteVideo()
}
