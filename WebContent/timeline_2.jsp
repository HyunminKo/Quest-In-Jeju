<%@ page contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="board.*" %><%
    
    String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	Exception err = null;
    
	CommentDAO dao = new CommentDAO();
	CommentVO vo = new CommentVO();
	
	Cookie[] cookies = request.getCookies();
	for( int i = 0 ; i < cookies.length ; i++ ) {
		if( ( "user_id" ).equals(cookies[i].getName()) ) {
			vo.setUser_id(Long.parseLong( cookies[i].getValue() ));
			break;
		}
	}
	
%><!DOCTYPE html>