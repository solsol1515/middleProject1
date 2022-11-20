<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
		String id = (String) session.getAttribute("id");
		
		if(id == "" || id == null){
			response.sendRedirect("list.jsp");
		}


%>