<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="board.*, java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%><%!

String ctxPath = null;
Exception err = null;
String[] datetimeSplit = null;
String poster = null;
String commenter = null;
PostDAO pdao = null;
CommentDAO cdao = null;
String categoryColor = null;

%><%

pdao = new PostDAO();
cdao = new CommentDAO();
List<PostVO> pls = null;
List<CommentVO> cls = null;

ctxPath = request.getContextPath();
request.setCharacterEncoding("UTF-8");

try {
	pls = pdao.findAll();
	request.setAttribute( "pls" , pls );
} catch( Exception e ) {
	err = e;
	request.setAttribute( "err" , err );
}

if( err != null ) response.sendRedirect( ctxPath + "/error.jsp" );

%><!DOCTYPE html>
<html lang="ko">
<head>

<title>TimeLine</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
  rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
/>
<link rel="stylesheet" href="static/css/quest_authentication.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
  type="text/javascript"
  src="http://code.jquery.com/jquery-2.1.0.min.js"
></script>
<link rel="stylesheet" href="static/css/main.css" />
<link rel="stylesheet" href="static/css/timeline.css"/>
</head>
<body>

<header>
    <%@include file="header.jsp"%>
</header>
<main>
    <img src="static/img/PlusButtonImage.png" class="PlusButtonImage" />
    
	<l:forEach  var="pvo" items="${pls}" varStatus="vs"><%
		Integer postCategory = Integer.valueOf(((PostVO) pageContext.getAttribute("pvo")).getCategory());
		if( postCategory == 1 ) categoryColor = "B";
	    else if( postCategory == 2 ) categoryColor = "G";
	    else if( postCategory == 3 ) categoryColor = "O";
		request.setAttribute("cc", categoryColor);
	    %><div class="MainTopLeft"></div>
	    <div class="MainTopRight">
	        <div class="MainTopRightUtilLeft">
	        	<input type="button" id="button_${vs.count}" class="<%= "LikeButton LikeButtonUtil" + categoryColor %>" onclick= "ClickOfLike( this )" />
	        </div>
	        <div class="<%= "MainTopRightUtil MainTopRightUtilUtil" + categoryColor %>">
	            <div class="MainTopRightUtilWrite">
	                <div class="MainTopRightUtilWriteBot">
	                    <div class="MainTopRightUtilWriteBotLeft">
	                        <img src="${pvo.filesystemname}" class="MainTopRightUtilWriteBotLeftImage"/>
	                    </div>
	                    <div class="MainTopRightUtilWriteBotRight">
	                        <p class="MainTopRightUtilWriteBotRightWrite">
	                        	${pvo.contents}
	                        </p>
	                    </div>
	                </div>
	                <div class=MainTopRightUtilWriteTop>
	                    <div class="MainTopRightUtilWriteTopLeft"><%
	                    	String id = String.valueOf(((PostVO) pageContext.getAttribute("pvo")).getUser_id());
	                    	poster = pdao.findNameByUserId(id);
	                    %> 
	                        <p class="WriteNickName">
	                        	<%= poster %>
	                        </p>
	                    </div>
	                    <div class="MainTopRightUtilWriteTopRight"><%
	                        	String postDate = String.valueOf(((PostVO) pageContext.getAttribute("pvo")).getDate());
	                        	datetimeSplit = postDate.split("\\s");
	                      %><p class="WriteDate">
	                        	<%= datetimeSplit[0] %>
	                        </p>
	                        <p class="WriteDatetime">
	                        	<%= datetimeSplit[1] %>
	                        </p>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="MainTopRightUtilWriter">
	                <div class="MainTopRightUtilWriterRight">
	                	<form method="POST" action="timeline_2.jsp" >
		                	<input type="submit" class="<%= "CommentSubmitButton CommentSubmitButtonUtil" + categoryColor %>" />
		                    <textarea class="WriterEditor" id="test" cols="45" rows="3" srcolling="no" onclick="this.value=''">댓글을 작성해주세요</textarea>
	                	</form>
	                </div>
	            </div>
	         	<%
	         	String check = String.valueOf(((PostVO) pageContext.getAttribute("pvo")).getId());
	         	try {
		        	cls = cdao.findAllByPostId( check );
		        	request.setAttribute( "cls" , cls );
	         	} catch( Exception e ) {
	         		err = e;
	         		request.setAttribute( "err" , err );
	         	}
	         	if( err != null ) response.sendRedirect( ctxPath + "/error.jsp" );
	         	%><l:forEach  var="cvo" items="${cls}">
            		<div class="MainTopRightUtilComment">
		                <div class="MainTopRightUtilCommentTop">
		                    <div class="MainTopRightUtilCommentTopLeft"><%
		                        String id2 = String.valueOf(((CommentVO) pageContext.getAttribute("cvo")).getUser_id());
	                  		  	commenter = cdao.findNameByUserId(id2);
		                    %><%= commenter %>
		                    </div>
		                    <div class="MainTopRightUtilCommentTopRight"><%
	                        	String commentDate = String.valueOf(((CommentVO) pageContext.getAttribute("cvo")).getDate());
	                        	datetimeSplit = commentDate.split("\\s");
	                      %><div class="MainTopRightUtilCommentTopRightLeft">
		                            <%= datetimeSplit[0] %>
		                        </div>
		                        <div class="MainTopRightUtilCommentTopRightRight">
		                            <%= datetimeSplit[1] %>
		                        </div>
		                    </div>
		                </div>
		                <div class="MainTopRightUtilCommentBot">
		                    ${cvo.contents}
		                </div>
		            </div>
				</l:forEach>
	        </div>
	    </div>
	</l:forEach>
</main>

<footer>
    <div class="MainBotTop">

    </div>
    <div class="MainBotBot">
        <div class="MainBotBotLeft">
            <input type="button" value="자유" class="MainBotBotLeftFreedom"/>
            <input type="button" value="전체" class="MainBotBotLeftAll"/>
        </div>
        <div class="MainBotBotRight">
            <input type="button" value="후기" class="MainBotBotRightReview"/>
            <input type="button" value="질문" class="MainBotBotRightQuestion"/>
        </div>
    </div>
</footer>

</body>

<script type="text/javascript">

    $(document).ready(function() {
        $('#test').on('keyup', function() {
            if($(this).val().length > 70) {
                $(this).val($(this).val().substring(0, 70));
            }
        });
    });
    function ClickOfLike( t ){
        $('#' + t.id ).toggleClass( "<%= "likedButton" + categoryColor %> ");
    }
</script>
<script src="static/js/main.js"></script>
</html>