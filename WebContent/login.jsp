<%@ page import ="user.UserDAO, user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%
	String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	UserDAO dao = new UserDAO();
	UserVO vo = 
	
	try {
		if (email.equals(password)) {
			response.sendRedirect( ctxpath + "/index.jsp" );
		}
		else {
			response.sendRedirect( ctxPath + "/mainlogin2.html");
		}
		
	}
	catch ( Exception e ) {
		
	}
	
%>
