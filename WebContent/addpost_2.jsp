<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="board.PostDAO, board.PostVO" %>
<%@ page import="file.FileUp" %>
<%@ page import="util.Utils" %>
<%
	String ctxPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	Exception err = null;
	PostDAO dao = new PostDAO();
	PostVO vo = new PostVO();
	try {
		vo.setLike_count(0);
		FileUp.fileUpload(request,"/post",vo);

		String userId = Utils.getValueInCookie(request,"user_id");
		if(userId!=null){
			vo.setUser_id(Long.parseLong(userId));
		}else {
			vo.setUser_id(1L);
		}

//		로그인 기능(쿠키에 사용자 ID 저장) 구현 이후 실행해야함.
//		Cookie[] cookies = request.getCookies();
//		for( int i = 0 ; i < cookies.length ; i++ ) {
//			if( ( "user_id" ).equals(cookies[i].getName()) ) {
//				vo.setUser_id(Long.parseLong( cookies[i].getValue() ));
//				break;
//			}
//		}

		dao.insert(vo);

	} catch (Exception e) {
		err = e;
		e.printStackTrace();
	}

	if( err != null ) {
		session.setAttribute("error",err);
		response.sendRedirect(ctxPath + "/error.jsp");
	}else{
		response.sendRedirect(ctxPath + "/timeline.jsp");
	}
%>