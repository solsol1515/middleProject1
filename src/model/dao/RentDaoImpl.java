package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.RentDao;


public class RentDaoImpl implements RentDao{

	final static String DRIVER   = "oracle.jdbc.driver.OracleDriver";
	final static String URL      = "jdbc:oracle:thin:@192.168.0.50:1521:xe";
	final static String USER     = "project";
	final static String PASS     = "1234";

	// Connection con;

	public RentDaoImpl() throws Exception{
		// 1. 드라이버로딩
		Class.forName(DRIVER);		
	}

	// 대여
	public void rentVideo(String tel, int vnum) throws Exception {

		// 2. connect 연결 객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASS);

			// 3. sql 문장 만들기
			String sql = "INSERT INTO RENT (rentno, video_no, rentdate, custtel1,  return)  "
					+ " VALUES (rent_seq.nextval, ?, sysdate, ?, 'N' )";

			// 4. sql 전송 객체
			ps = con.prepareStatement(sql);

			ps.setInt(1, vnum);
			ps.setString(2, tel);

			ps.executeUpdate();	

			//clearText();
			// 5. 전송
		} finally {
			ps.close();
			con.close();
		} // end of finally

	} // end of rentVideo()

	// 반납
	public void returnVideo(int vnum) throws Exception {
		// 2. connect 연결 객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASS);

			String sql = "UPDATE RENT SET RETURN = 'Y' "
					+ " WHERE video_no = ?  AND RETURN = 'N'";

			ps = con.prepareStatement(sql);
			ps.setInt(1, vnum);

			ps.executeUpdate();	

		} finally {
			ps.close();
			con.close();
		} // end of finally

	} // end of returnVideo()

	// 미납 목록
	public ArrayList selectList() throws Exception {

		ArrayList data = new ArrayList(); // 저장할 데이터가 여러종류라서 ArrayList 사용

			// (2) 연결 객체 얻어오기
				Connection con 		 = null;
				PreparedStatement ps = null;

				try {
					con = DriverManager.getConnection(URL, USER, PASS);

			// (3) sql 문장 
			String sql = "SELECT V.VIDEO_NO video_no, V.TITLE title, C.CUSTNAME custname, "
					   + "   C.CUSTTEL1 custtel1, R.RENTDATE rentdate, '미납' ret  "
					   + "  FROM RENT R INNER JOIN  CUSTOMER C ON C.CUSTTEL1 = R.CUSTTEL1  "
					   + "  INNER JOIN VIDEO V  "
					   + "  ON V.VIDEO_NO = R.VIDEO_NO  "
					   + "  WHERE R.RETURN = 'N' ";
			// tfVideoSearch에 입력된 값인 word를 포함한 문자열을 검색해줌

			System.out.println(sql);

			// (4) 전송 객체 
				ps = con.prepareStatement(sql);

			// (5) 전송
				ResultSet rs = ps.executeQuery(); // rs로 데이터 받음.

				while(rs.next()) { // 선택한 요소의 다음 요소를 선택

					ArrayList temp = new ArrayList(); 

					temp.add(rs.getInt("video_no"));		// 비디오 번호
					temp.add(rs.getString("title"));		// 비디오 제목
					temp.add(rs.getString("custname"));		// 고객명
					temp.add(rs.getString("custtel1"));		// 전화번호
					temp.add(rs.getString("rentdate"));		// 반납 예정일
					temp.add(rs.getString("ret"));			// 반납 여부

					data.add(temp); // data에 temp 데이터 한꺼번에 담기 
				}

				} finally {
					
			// 6. 닫기
				ps.close();
				con.close();

				} // end of finally
					return data;

	} // end of selectList()
	
	public String rentSelectTel(String tel) throws Exception{
		// (2) 연결 객체 얻어오기
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		String name = null;
		
		try {
		
			con = DriverManager.getConnection(URL, USER, PASS);
			
		// (3) sql 문장
			
			String sql = "SELECT CUSTNAME FROM CUSTOMER WHERE CUSTTEL1 = ?";
			
		// (4) sql 전송 객체 
			
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			
		// (5) 전송
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("CUSTNAME");
			}
			return name;
			
		}finally {
			rs.close();
			con.close();
		}
	} // end of rentSelectTel()
			
}
