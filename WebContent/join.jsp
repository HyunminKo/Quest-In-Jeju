<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="user.UserDAO, user.UserVO"%>
<%@ page import ="java.lang.*"%>
<%
	String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	Long id = Long.parseLong(request.getParameter("id"));
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String password = request.getParameter("password");

	UserDAO dao = new UserDAO();
	UserVO vo = dao.findPwByEmail(email);
	
	try {
		if (email.equals(vo.getEmail())) {
			if(password.equals(vo.getPassword())) {
				response.addCookie(new Cookie("user_id",String.valueOf(vo.getId())));
				response.addCookie(new Cookie("user_name",vo.getName()));
				response.sendRedirect( ctxPath + "/index.jsp" );
			}
			
		}
	}
	
	catch ( Exception e ) {
		
	}
	//비밀번호 두개 일치하는지 확인 

%>