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

<title>Time Line</title>
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
<script src="static/js/main.js"></script>
<style>

* {
    margin: 0;
    padding: 0;
}

@font-face {
  font-family: "BRBA_B";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_seven@1.2/BRBA_B.woff")
  format("woff");
  font-weight: normal;
  font-style: normal;
}

body {
    width : 100%;
    height : 100%;
}

header {
    width : 100%;
    height : 10%;
    background-color : #da0808;
}

main {
    width : 100%;
    height : 81%;
    overflow-y : auto;
    overflow-x : hidden;
}

footer {
    width : 100%;
    height : 9%;
}

/*~~~~~~~~~~~~~~ Main ~~~~~~~~~~~~~~~~*/

.MainTopLeft {
    width : 8%;
    float : left;
}

.MainTopRight {
    width : 92%;
    float : right;
    border-left : 2px solid #eee;
}

.MainTopRightUtilLeft {
    width : 10%;
    z-index : 2;
    float : left;
    margin-top : 8%;
    position : relative;
    right : 6%;
}

.LikeButton {
	width : 10vw;
    height : 10vw;
    border-radius : 100%;
    background-color : white;
    -webkit-transition:width 0.5s, height 0.5s, background-color 0.5s, -webkit-transform 0.5s;
    transition:width 0.5s, height 0.5s, background-color 0.5s, transform 0.5s;
}
.LikeButtonUtilB {
    border : 2px solid #03a9f4;
}
.LikeButtonUtilG {
    border : 2px solid #8bc34a;
}
.LikeButtonUtilO {
    border : 2px solid #ffc107;
}


.likedButtonB {
	background-color : #03a9f4;
    -moz-transform: scale(1.3);
    -webkit-transform: scale(1.3);
    -o-transform: scale(1.3);
    -ms-transform: scale(1.3);
    transform: scale(1.3);
    -webkit-transition:width 0.5s, height 0.5s, background-color 0.5s, -webkit-transform 0.5s;
    transition:width 0.5s, height 0.5s, background-color 0.5s, transform 0.5s;
}
.likedButtonG {
	background-color : #8bc34a;
    -moz-transform: scale(1.3);
    -webkit-transform: scale(1.3);
    -o-transform: scale(1.3);
    -ms-transform: scale(1.3);
    transform: scale(1.3);
    -webkit-transition:width 0.5s, height 0.5s, background-color 0.5s, -webkit-transform 0.5s;
    transition:width 0.5s, height 0.5s, background-color 0.5s, transform 0.5s;
}
.likedButtonO {
	background-color : #ffc107;
    -moz-transform: scale(1.3);
    -webkit-transform: scale(1.3);
    -o-transform: scale(1.3);
    -ms-transform: scale(1.3);
    transform: scale(1.3);
    -webkit-transition:width 0.5s, height 0.5s, background-color 0.5s, -webkit-transform 0.5s;
    transition:width 0.5s, height 0.5s, background-color 0.5s, transform 0.5s;
}

.MainTopRightUtil {
	width : 85%;
	margin-top : 8%;
	margin-right : 5%;
	float : right;
	border : 1px solid #eee;
}
.MainTopRightUtilUtilB {
    border-left : 5px solid #03a9f4;
}
.MainTopRightUtilUtilG {
    border-left : 5px solid #8bc34a;
}
.MainTopRightUtilUtilO {
    border-left : 5px solid #ffc107;
}

.MainTopRightUtilWrite {
    width : 100%;
}

.MainTopRightUtilWriteTop {
    width : 100%;
    height : 25px;
}

.MainTopRightUtilWriteTopLeft {
    width : 40%;
    height : 100%;
    float : left;
    padding : 1%;
}

p.WriteNickName {
    font-size : 15px;
    margin : 0px 0px 0px 5px;
}

.MainTopRightUtilWriteTopRight {
    width : 55%;
    height : 100%;;
    float : right;
    display : flex;
    padding : 2% 2% 2% 15%;
}

p.WriteDatetime {
    font-size : 8px;
    color : #eee;
    margin : 0px;
    text-align : right;
}

p.WriteDate {
    font-size : 10px;
    margin : 0px 2vw 0px 0px;
    text-align : right;
}

.MainTopRightUtilWriteBot {
    width : 100%;
}

.MainTopRightUtilWriteBotLeft {
    width : 30vw;
    height : 30vw;
    margin : 2vw;
    float : left;
}

.MainTopRightUtilWriteBotLeftImage {
    width : 100%;
    height : 100%;
}

.MainTopRightUtilWriteBotRight {
    width : 38vw;
    height : 15vw;
    margin : 2vw;
    float : right;
}

.MainTopRightUtilWriteBotRightWrite {
    width : 100%;
    height : 100%;
    font-size : 10px;
    display : -webkit-box;
    overflow : hidden;
    vertical-align : top;
    text-overflow : ellipsis;
    word-break : break-all;
    -webkit-box-orient : vertical;
    -webkit-line-clamp : 4
}

.MainTopRightUtilWriter {
    width : 100%;
    height : 15vh;
    display : block;
}

.MainTopRightUtilWriterRight {
    width : 99%;
    border-bottom : 1px solid #eee;
    float : right;
}

.CommentSubmitButton {
	width : 11vw;
	height : 11vw;
	text-align : center;
	background-color : #ffffff;
	border-radius : 10%;
	box-shadow : 0px 0px;
	float : right;
	border-top : 0px;
	border-bottom : 0px;
}
.CommentSubmitButtonUtilB {
	border-left : 1px solid #03a9f4;
	border-right : 1px solid #03a9f4;
	color : #03a9f4;
}
.CommentSubmitButtonUtilG {
	border-left : 1px solid #8bc34a;
	border-right : 1px solid #8bc34a;
	color : #8bc34a;
}
.CommentSubmitButtonUtilO {
	border-left : 1px solid #ffc107;
	border-right : 1px solid #ffc107;
	color : #ffc107;
}

textarea.WriterEditor {
    font-size : 7px;
    border-top : 0px solid #eee;
    border-bottom : 0px solid #eee;
    border-left : 0px solid #eee;
    border-right : 0px solid #eee;
    resize : none;
    float : left;
}

.MainTopRightUtilComment {
    width : 100%;
    display : block;
}

.MainTopRightUtilCommentTop {
    width : 100%;
    font-size : 11px;
}

.MainTopRightUtilCommentTopLeft {
    width : 40%;
    float : left;
    padding : 2px 2px 2px 5px;
}

.MainTopRightUtilCommentTopRight {
    width : 60%;
    float : right;
}

.MainTopRightUtilCommentTopRightLeft {
    width : 60%;
    float : left;
    padding : 3px 3px 2px 25px;
    font-size : 8px;
    text-align : right;
}

.MainTopRightUtilCommentTopRightRight {
    width : 40%;
    float : right;
    padding : 3px 3px 2px 3px;
    color : #eee;
    font-size : 7px;
}

.MainTopRightUtilCommentBot {
    width : 100%;
    padding : 8px;
    font-size : 7px;
    border-top : 1px solid #eee;
}

.MainBotTop {
    width : 100%;
    height : 10%;
    background-color : #da0808;
}

.MainBotBot {
    width : 100%;
    height : 90%;
    background-color : #FFFFFF;
}

.MainBotBotLeft {
    width : 50%;
    height : 100%;
    float : left;
}

.MainBotBotLeftAll {
    width : 55px;
    height : 35px;
    float : right;
    background-color : #da0808;
    border : 1px solid #da0808;
    margin : 8px 5px 0px 5px;
    border-radius : 55px;
    color : white;
    font-size : 15px;
}

.MainBotBotLeftFreedom {
    width : 55px;
    height : 35px;
    float : right;
    background-color : #03a9f4;
    border : 1px solid #03a9f4;
    margin : 8px 5px 0px 5px;
    border-radius : 55px;
    color : white;
    font-size : 15px;
}

.MainBotBotRight {
    width : 50%;
    height : 100%;
    float : right;
}

.MainBotBotRightReview {
    width : 55px;
    height : 35px;
    float : left;
    background-color : #8bc34a;
    border : 1px solid #8bc34a;
    margin : 8px 5px 0px 5px;
    border-radius : 55px;
    color : white;
    font-size : 15px;
}

.MainBotBotRightQuestion {
    width : 55px;
    height : 35px;
    float : left;
    background-color : #ffc107;
    border : 1px solid #ffc107;
    margin : 8px 5px 0px 5px;
    border-radius : 55px;
    color : white;
    font-size : 15px;
}

.PlusButtonImage {
    width : 15vw;
    height : 15vw;
    position : fixed;
    margin : 70vh 10vw 10vh 80vw;
}

</style>
</head>
<body>

<header>
    <%@include file="header.jsp"%>
</header>
<main>
    <img src="static/img/PlusButtonImage.png" class="PlusButtonImage" />
    
	<l:forEach  var="pvo" items="${pls}"><%
		Integer postCategory = Integer.valueOf(((PostVO) pageContext.getAttribute("pvo")).getCategory());
		if( postCategory == 1 ) categoryColor = "B";
	    else if( postCategory == 2 ) categoryColor = "G";
	    else if( postCategory == 3 ) categoryColor = "O";
	    %><div class="MainTopLeft"></div>
	    <div class="MainTopRight">
	        <div class="MainTopRightUtilLeft">
	        	<input type="button" id="likeButton_1" class="<%= "LikeButton LikeButtonUtil" + categoryColor %>" onclick= "ClickOfLike( this.id )" />
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
    function ClickOfLike( id ){
        $( "#" + id ).toggleClass( "<%= "likedButton" + categoryColor %>" );
    }
</script>

</html>