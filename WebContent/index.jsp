<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"
    import="java.util.List, quest.*"%>

   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>

<%
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
    <title>QuestInJeJu</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1da8ruo4kk"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="static/css/quest_page.css" />
    <link rel="stylesheet" href="static/css/main.css" />
    <script src="static/js/main.js"></script>
  </head>

  <body>
    <div class="nav">
      <div id="menu" class="menu">
        <a class="navbar-brand" href="#" id="link_1" onclick="showStateIcons(this)">
          <img id="img_1" src="static/img/flag.png" width="30" height="30" alt=""/>
        </a>
        <a class="navbar-brand" href="#" id="link_2" onclick="showStateIcons(this)">
          <img id="img_2" src="static/img/placeholder.png" width="30" height="30" alt=""/>
        </a>
        <a class="navbar-brand" href="#" id="link_3" onclick="showStateIcons(this)">
          <img id="img_3" src="static/img/person.png" width="30" height="30" alt=""/>
        </a>
        <a class="navbar-brand" href="#" id="link_4" onclick="showStateIcons(this)">
          <img id="img_4" src="static/img/timeline.png" width="30" height="30" alt=""/>
        </a>
       </div>

      <div id="header-title">
        <span>Quest In JeJu</span>
      </div>
    </div>
    <div id="map" class="naver-map"></div>


        <div class="quest"  style="font-size:30px">
        <p > ________님이 수행중인 퀘스트!</p>
        </div>

  <div class="container">

      <div class="button" ><a href="javascript:doDisplayo();">
      			<button type="button" class="btn btn-outline-danger ">오름 정복하기</button>
      		</a></div>


    <!--오름리스트-->
    <div class="container2" id="orumlist">
      

          <div class="auth-wrap"> <!--y-scroll-->

<!--여기부터.. for-->

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
</html>













