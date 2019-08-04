<%@ page contentType=“text/html;charset=UTF-8” language=“java”
	import="board.PostVO, board.PostDAO" %>
<%
	Exception err = null;

	String contents = request.getParameter("contents");
	String date = request.getParameter("date");
	Long user_id = null;
	String src = request.getParameter("src");
	Integer category = Integer.parseInt( request.getParameter("category") );
	
	Cookie[] cookies = request.getCookies();
	
	try {
		for( int i = 0 ; i < cookies.length ; i++ ) {
			if( ( cookies[i].getName() ).equals("user_id") ) {
				user_id = Long.parseLong( cookies[i].getValue() );
				break;
			}
		}
		throw new Exception();
	} catch( Exception e ) {
		err = e;
	}
	
	PostVO vo = new PostVO();
	
	vo.setContents( contents );
	vo.setDate( date );
	vo.setUser_id( user_id );
	vo.setSrc( src );
	vo.setCategory( category );
	
	PostDAO dao = new PostDAO();
	try {
		dao.insert( vo );
	} catch ( Exception e ) {
		err = e;
	}
	
	if( err != null ) response.sendRedirect("/jdbcUtil/error.jsp");
	else response.sendRedirect("/timeline.jsp");
%><!DOCTYPE html>
<html>
<body>

</body>
</html>