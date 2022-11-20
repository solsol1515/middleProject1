<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<% 
		String id 	= request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "tiger");
		
		String sql = "select member_id id, pw from judamember where id=? and pw=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			out.print("접속성공");
			session.setAttribute("id", "hansol");
			session.setAttribute("pw", "0215");
			
			response.sendRedirect("index.jsp"); // 로그인하면 인덱스 화면으로 이동
// 			session.setAttribute("pw", "0215");
		}else{
			out.print("접속실패ㅠㅠ");
			response.sendRedirect("login.jsp"); // 로그인 실패할 경우 다시 로그인 화면으로 이동
		}
		
		
		
		%>