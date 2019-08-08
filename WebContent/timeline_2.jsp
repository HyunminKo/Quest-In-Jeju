<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"
    import="board.CommentDAO , board.CommentVO , util.Utils" %><%!
	
    String ctxPath = null;
    Exception err = null;
    CommentDAO dao = null;
    CommentVO vo = null;
    %><%
    
    System.out.println( 1 );
    
    try {
	    ctxPath = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		dao = new CommentDAO();
		vo = new CommentVO();
		
		String contents = request.getParameter("comment");
		String pd = request.getParameter("post_id");
		String poid = pd.replaceAll(" ", "");
		Long post_id = Long.parseLong( poid );
		Long user_id = Long.parseLong( Utils.getValueInCookie( request , "user_id" ) );
		
		vo.setContents( contents );
		vo.setPost_id( post_id );
		vo.setUser_id( user_id );
		
		dao.insert( vo );
    } catch( Exception e ) {
    	err = e;
    }
    
    //if( err != null )
    response.sendRedirect( ctxPath + "/timeline.jsp" );
    //else response.sendRedirect( ctxPath + "/error.jsp" );
    
%><!DOCTYPE html>