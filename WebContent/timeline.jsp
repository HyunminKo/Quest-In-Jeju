<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"
    import="board.*, java.util.*, util.Utils , relation.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%><%!

String ctxPath = null;
Exception err = null;
String[] datetimeSplit = null;
String poster = null;
String commenter = null;
PostDAO pdao = null;
CommentDAO cdao = null;
String categoryColor = null;
String lo = "1";
String LikeCheck = null;
UserPostLikeDAO ldao = null;
UserPostLikeVO lvo = null;
List<UserPostLikeVO> lls = null;

%><%

pdao = new PostDAO();
cdao = new CommentDAO();
ldao = new UserPostLikeDAO();
List<PostVO> pls = null;
List<CommentVO> cls = null;

ctxPath = request.getContextPath();
request.setCharacterEncoding("UTF-8");

lo = request.getParameter("lo");
if( lo == null ) lo = "1";
try {
	pls = pdao.findAllCategory( lo );
	request.setAttribute( "pls" , pls );
	
	lls = ldao.findAll();
	request.setAttribute( "lls" , lls );
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
<link rel="stylesheet" href="static/css/main.css" />
<link rel="stylesheet" href="static/css/timeline.css"/>
</head>
<body>

<header>
    <%@include file="header.jsp"%>
</header>
<main>
    <img src="static/img/PlusButtonImage.png" class="PlusButtonImage" data-toggle="modal" data-target="#posting_modal"/>
    
    <l:forEach  var="pvo" items="${pls}" varStatus="vs"><%
		Integer postCategory = Integer.valueOf(((PostVO) pageContext.getAttribute("pvo")).getCategory());
		if( postCategory == 1 ) categoryColor = "B";
	    else if( postCategory == 2 ) categoryColor = "G";
	    else if( postCategory == 3 ) categoryColor = "O";
		request.setAttribute("cc", categoryColor);
	    %><div class="MainTopLeft"></div>
	    <div class="MainTopRight">
	        <div class="MainTopRightUtilLeft">
	        	<input type="button" id="button_${vs.count}_${cc}" class="LikeButton LikeButtonUtil${cc} LikedButton${cc}" onclick="ClickOfLike( this )"/>
	        </div>
	        <div class="<%= "MainTopRightUtil MainTopRightUtilUtil" + categoryColor %>">
	            <div class="MainTopRightUtilWrite">
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
	            </div>
	            
	            <div class="MainTopRightUtilWriter">
	                <div class="MainTopRightUtilWriterRight">
	                	<form method="POST" action="timeline_2.jsp" >
	                		<input type="hidden" name="post_id" value=" <%= String.valueOf(((PostVO)pageContext.getAttribute("pvo")).getId()) %>" />
		                	<input type="submit" class="<%= "CommentSubmitButton CommentSubmitButtonUtil" + categoryColor %>" value="작성" />
		                    <textarea name="comment" class="WriterEditor" id="test" cols="45" rows="3" srcolling="no" placeholder="댓글을 작성하세요."></textarea>
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
	         	}
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
		                	<p class="CommentOfOne">
		                    	${cvo.contents}
		                	</p>
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
        	<form method="POST" action="timeline.jsp">
        		<input type="hidden" value="2" name="lo"/>
            	<input type="submit" value="자유" class="MainBotBotLeftFreedom"/>
            </form>
            <form method="POST" action="timeline.jsp">
        		<input type="hidden" value="1" name="lo"/>
            	<input type="submit" value="전체" class="MainBotBotLeftAll"/>
            </form>	
        </div>
        <div class="MainBotBotRight">
        	<form method="POST" action="timeline.jsp">
        		<input type="hidden" value="3" name="lo"/>
	            <input type="submit" value="후기" class="MainBotBotRightReview"/>
	        </form>
            <form method="POST" action="timeline.jsp">
        		<input type="hidden" value="4" name="lo"/>
	            <input type="submit" value="질문" class="MainBotBotRightQuestion"/>
	        </form>
        </div>
    </div>
</footer>
<div class="modal fade" id="posting_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalScrollableTitle"><b class="tl-bold">|&nbsp;</b>새 글 작성</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form method="POST" action="addpost_2.jsp" enctype="multipart/form-data" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input type="radio" value="1" name="category" id="free" checked/>
						<label for="free">자유</label>
						<input type="radio" value="2" name="category" id="review"/>
						<label for="review">후기</label>
						<input type="radio" value="3" name="category" id="question"/>
						<label for="question">질문</label>
					</div>
					<div class="form-group">
						<textarea class="tl-new" name="contents" cols="40" rows="11"></textarea>
						<input type="file" name="file" class="tl-select" />
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-group">
						<input type="submit" class="tl-upload" name="submit" value="업로드" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
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
    	let color = t.id.split("_")[2];
        $('#' + t.id ).toggleClass("likedButton"+color);
    }
</script>
<script src="static/js/main.js"></script>
</html>