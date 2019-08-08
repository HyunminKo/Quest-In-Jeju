<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="user.UserDAO, user.UserVO"%>
<%@ page import ="java.lang.*, java.util.*"%>
<%
	String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	String email = request.getParameter("joinEmail");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	
	UserDAO dao = new UserDAO();
	UserVO vo = new UserVO();
	vo.setEmail(email);
	vo.setName(name);
	vo.setPassword(password);
	int result = dao.insert(vo);
	if(result != -1){ //success
		Long userId = dao.findIdByEmail(email);
		response.addCookie(new Cookie("user_id",String.valueOf(userId)));
		response.sendRedirect(ctxPath);
	}else { //fail
		out.println("<script>alert('회원가입에 실패하였습니다. 잠시 후 다시 시도하세요.');location.href='index.jsp';</script>");
		out.flush();
	}

%>

	