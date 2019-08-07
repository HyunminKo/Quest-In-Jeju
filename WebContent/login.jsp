<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import ="user.UserDAO, user.UserVO"%>
<%
	String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	UserDAO dao = new UserDAO();
	UserVO vo = dao.findPwByEmail(email);
	
	try {
		if(vo == null){
			%>
			<script>
				alert("이메일이 존재하지 않습니다.");
				history.back();
			</script>
			<%
			return;
		}
		if (email.equals(vo.getEmail())) {
			if(password.equals(vo.getPassword())){
				response.addCookie(new Cookie("user_id",String.valueOf(vo.getId())));
				response.addCookie(new Cookie("user_name",vo.getName()));
				response.sendRedirect( ctxPath + "/index.jsp" );
			}else {
				%>
					<script>
						alert("비밀번호가 틀렸습니다!");
						history.back();
					</script>
				<%
			}
		}
	}
	catch ( Exception e ) {
		
	}
	
%>
