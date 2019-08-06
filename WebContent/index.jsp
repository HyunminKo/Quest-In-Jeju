<%@ page contentType="text/html; charset=utf-8"
    import="java.util.List, quest.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<%
  Cookie[] cookies = request.getCookies();
  String userId = null;
  for( int i = 0 ; i < cookies.length ; i++ ) {
      if( ( "user_id" ).equals(cookies[i].getName()) ) {
          userId = cookies[i].getValue();
          break;
      }
  }
  System.out.println(userId);


  List<QuestItemVO> rl = null;
  List<QuestVO> rl2 = null;
	Exception err = null;


  QuestItemDAO dao = new QuestItemDAO();
  try{
  	rl = dao.findAll();
  	request.setAttribute("rl", rl);
  	System.out.println(rl);
  }catch(Exception e){
  	err = e;
  }

	QuestDAO dao2 = new QuestDAO();
	try{
		rl2 = dao2.findAll();
		request.setAttribute("rl2",rl2);
	}catch(Exception e){
		err = e;
	}

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="theme-color" content="#999999" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>

    <title>Index</title>

    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1da8ruo4kk"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="static/css/quest_page.css" />
    <link rel="stylesheet" href="static/css/main.css" />

  </head>

  <body>
    <%@include file="header.jsp" %>

    <div id="map" class="naver-map"></div>
    <div class="quest"  style="font-size:30px">
    <p class="gothic"> ________님이 수행중인 퀘스트!</p>
    </div>
        <div class="container">

          <div class="button" ><a href="javascript:doDisplayo();">
      			<button type="button" class="btn btn-outline-danger ">오름정복하기이이이</button>
      		</a></div>
    <div class="container2" id="orumlist">

          <div class="auth-wrap"> <!--y-scroll-->

	          <l:forEach  var="vo" items="${rl}">
                <div class="questlist">
                  <div class ="abcd">
                      <button type="button" class="btn btn-outline-secondary naming" >${vo.name}</button>
                  </div>

                  <div class="authbtn">
                        <button type="button"  class="btn btn-outline-success chkbtn"><img src="static/img/submit.png"></button>

                    </div><!--authbtn-->
                </div><!--questlist-->

	            </l:forEach>

        </div><!--authwrap-->
    </div><!--container2-->
  </body>
  <script src="static/js/naver_map.js"></script>
  <script src="static/js/main.js"></script>
  <script src="static/js/get_playing_quest.js"></script>
</html>
