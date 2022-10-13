package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.CustomerVO;

public class CustomerDaoImpl implements CustomerDao{

	   final static String DRIVER   = "oracle.jdbc.driver.OracleDriver";
	   final static String URL      = "jdbc:oracle:thin:@192.168.0.50:1521:xe";
	   final static String USER     = "project";
	   final static String PASS     = "1234";
	
	   
	public CustomerDaoImpl() throws Exception{
	 	// 1. 드라이버로딩
		Class.forName(DRIVER);
	    System.out.println("드라이버로딩 성공");
	}
	
	/*
	 * 메소드명 	: insertCustomer
	 * 인자	 	: (CustomerVO) 고객 정보(고객이름, 전화번호, 비상 전화번호, 주소, 이메일)
	 * 리턴값		: 고객 정보 등록
	 * 역할		: 신규 가입 회원 정보 등록
	 */
	
	// 회원 가입
	public void insertCustomer(CustomerVO vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con 		 = null;
		PreparedStatement ps = null;
		
		try {
			   con = DriverManager.getConnection(URL, USER, PASS);
			   
		// 3. sql 문장 만들기
		String sql = "INSERT INTO CUSTOMER (custName, custTel1, custTel2, custAddr, custEmail) VALUES (?, ?, ?, ?, ?)";
		
		// 4. sql 전송객체 (PrepareStatement)		
		ps = con.prepareStatement(sql);
		   ps.setString(1, vo.getCustName());
		   ps.setString(2, vo.getCustTel1());
		   ps.setString(3, vo.getCustTel2());
		   ps.setString(4, vo.getCustAddr());
		   ps.setString(5, vo.getCustEmail());
		
		// 5. sql 전송
		   ps.executeUpdate();	// insert
		
		}finally {
		// 6. 닫기 
			  ps.close();
			  con.close();
		   }
		
	   }// end of insertCustomer()
	
	/*
	 * 메소드명	: selectByTel
	 * 인자		: (String) 검색할 전화번호
	 * 리턴값		: (CustomerVO) 전화번호 검색에 따른 고객정보(이름, 주소, 이메일)
	 * 역할		: 사용자가 입력한 전화번호를 받아서 해당하는 고객 정보를 리턴 
	 */
	
	public CustomerVO selectByTel(String tel) throws Exception{
		
			CustomerVO vo 			= new CustomerVO();
			Connection con 			= null;
			PreparedStatement ps 	= null;
		
		// (2) 연결 객체 얻어오기
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		
		// (3) sql 문장 만들기
			String sql = "SELECT * FROM CUSTOMER WHERE CUSTTEL1 = ?";
		
		// 4. 전송객체 
			ps = con.prepareStatement(sql);
				ps.setString(1, tel);

		// 5. 전송 - executeQuery()
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			vo.setCustName(rs.getString("custname"));
			vo.setCustTel1(rs.getString("custtel1"));
			vo.setCustTel2(rs.getString("custtel2"));
			vo.setCustAddr(rs.getString("custaddr"));
			vo.setCustEmail(rs.getString("custemail"));
		}
		
		// 결과를 CustomerVO에 담기 
		
		} finally {
		
			// 6. 닫기 
			ps.close();
			con.close();
		} 
		return vo;
		
	} // end of selectByTel()
	
	/*
	 * 메소드명	: updateCustomer
	 * 인자		: (CustomerVO) 전화번호 검색에 의한 고객 정보(이름, 전화번호, 비상 전화번호, 주소, 이메일)
	 * 리턴값		: (int) 수정한 고객정보(이름, 전화번호, 비상 전화번호, 주소, 이메일)
	 * 역할		: 수정할 고객 정보를 업데이트
	 */
	
	public int updateCustomer(CustomerVO vo) throws Exception{
		
		// 2. 연결 객체 얻어오기
		   Connection con 		= null;
		   PreparedStatement ps = null;
		  
		   try {
			   con = DriverManager.getConnection(URL, USER, PASS);
			   
		// 3. sql 문장 만들기
		   String sql = "UPDATE CUSTOMER SET CUSTNAME =?, CUSTTEL2 = ?,		"
				   	  + " CUSTADDR = ?, CUSTEMAIL = ?"
				      + " WHERE CUSTTEL1 = ?";
		
		// 4. 전송 객체 얻어오기
		   ps = con.prepareStatement(sql);
		   ps.setString(1, vo.getCustName()); 	// 이름 얻어오기
		   ps.setString(2, vo.getCustTel2()); 	// 비상 전화번호 얻어오기
		   ps.setString(3, vo.getCustAddr()); 	// 주소 얻어오기
		   ps.setString(4, vo.getCustEmail()); 	// 이메일 주소 얻어오기
		   ps.setString(5, vo.getCustTel1()); 	// 전화번호 얻어오기
		
		// 5. 전송
		   ps.executeUpdate();
		   } finally {
			   
		// 6. 닫기
			   ps.close();
  			   con.close();	   
		   } // end of finally
		   
		   int result = 0;
		   
		return result;
	} // end of updateCustomer()
}
