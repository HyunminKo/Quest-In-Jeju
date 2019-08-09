<%@ page contentType="text/html; charset=utf-8"
    import="quest.QuestDAO, quest.QuestItemVO"%>
<%@ page import="util.Utils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
    String userId = Utils.getValueInCookie(request,"user_id");
    String userName = Utils.getValueInCookie(request,"user_name");
    String initLoaded = (String) session.getAttribute("init_load");
    request.setAttribute("initLoaded",initLoaded);

    Exception err = null;
    String ctxPath = request.getContextPath();
    QuestDAO dao = new QuestDAO();

    Map<Long,String> questNameMap = dao.getQuestNameMap();
    System.out.println("userId: " + userId);
    System.out.println("userName: " + userName);
    System.out.println("initLoaded: " + initLoaded);
    if(initLoaded == null) {
        if (userId != null) {
            try {
                dao.getPlayingUserQuest(request, Long.parseLong(userId));
                Map<Long,List<QuestItemVO>> questList = (Map<Long,List<QuestItemVO>>) session.getAttribute("questList");
                request.setAttribute("questNameMap",questNameMap);
                request.setAttribute("questList",questList);
                session.setAttribute("init_load", "true");
            } catch (Exception e) {
                err = e;
            }
        }
    }else {
        questNameMap = dao.getQuestNameMap();
        dao.getPlayingUserQuest(request, Long.parseLong(userId));
        Map<Long, Integer> userItemsInfoMap = (Map<Long, Integer>) session.getAttribute("userItemsInfoMap");
        Map<Long, Integer> questCount = (Map<Long, Integer>) session.getAttribute("questCount");

        Map<Long,Integer> questItemCount = (Map<Long,Integer>) session.getAttribute("questItemCount");
        request.setAttribute("questItemCount",questItemCount);
        request.setAttribute("questCount",questCount);
        request.setAttribute("userItemsInfoMap",userItemsInfoMap);
        request.setAttribute("questNameMap",questNameMap);
        Map<Long,List<QuestItemVO>> questList = (Map<Long,List<QuestItemVO>>) session.getAttribute("questList");
        request.setAttribute("questList",questList);
    }
    if (userId != null) {
        request.setAttribute("userId", userId);
    }
    if (userName != null) {
        request.setAttribute("userName", userName);
    }
    if(err!=null){
        err.printStackTrace();
        request.setAttribute("err",err);
        response.sendRedirect("error.jsp");
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

    <link rel="stylesheet" href="static/css/main.css"/>
    <link rel="stylesheet" href="static/css/mainlogin.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="static/css/loading_spinner.css"/>
    <link rel="stylesheet" href="static/css/progressbar.css"/>
  </head>
	<body onload="isLogin(${userId})">
 <%@include file="header.jsp" %>
    <div id="map" class="naver-map"></div>
	<l:choose>
		<l:when test="${not empty userId}">
        <div class="main-body-content">
		    <div class="quest-main-title">
		        <span>${userName}님이 수행중인 퀘스트!</span>
		    </div>
            <l:forEach var="rl" items="${questList}">
                <l:set var="quest_key" value="${rl.key}"/>
                <div class="row quest-list quest-list-main">

                <p class="quest-title">${questNameMap[quest_key]}</p>
                <ul class="quest-ul">
                    <li>
                        <div class="progress-card">
                            <div class="progress-head">
                                <!-- 테스트 프로그래스바 -->
                                <fmt:formatNumber var="result" value="${questItemCount[quest_key] div questCount[quest_key]}"/>
                                <fmt:formatNumber var="rs" value="${result div 10}" pattern="#"/>
                                <svg class="radial-progress" data-percentage="${rs}" viewBox="0 0 80 80">
                                    <circle class="incomplete" cx="40" cy="40" r="35"></circle>
                                    <circle class="complete" cx="40" cy="40" r="35" style="stroke-dashoffset: 39.58406743523136;"></circle>
                                    <text class="percentage" x="50%" y="57%" transform="matrix(0, 1, -1, 0, 80, 0)">${rs}%</text>
                                </svg>
                            </div>
                            <div class="progress-body">
                                <p class="title">${questItemCount[quest_key]} / ${questCount[quest_key]}</p>
                            </div>
                        </div>
                    </li>
                    <l:forEach var="vo" items="${rl.value}">
                    <li>
                        <div class="quest-card">
                            <div class="quest-head">
                                <img src="${vo.fileSystemName}" width="150" height="100/">
                            </div>
                            <div class="quest-body">
                                <p class="quest-body-title">${vo.name}</p>
                                <div class="authbtn">
                                    <l:choose>
                                        <l:when test="${userItemsInfoMap[vo.id] eq 0}">
                                            <button type="button"  class="btn btn-outline-danger">
                                                <a href="quest_authentication.jsp?item_id=${vo.id}&quest_id=${quest_key}" class="quest-item-a">
                                                    인증
                                                </a>
                                            </button>
                                        </l:when>
                                        <l:otherwise>
                                            <button type="button"  class="btn btn-outline-success">
                                                    인증 완료
                                            </button>
                                        </l:otherwise>
                                    </l:choose>
                                </div>
                            </div>
                        </div>
                    </li>
                    </l:forEach>
                </ul>
            </div>
            </l:forEach>
        </div>
  </l:when>
 <l:otherwise>
    <!-- 로그인 안했을때 보이는 부분  -->
    <div class="main-intro">
    <p>퀘스트를 시작하시려면 <br>로그인, 또는 회원가입을 해주세요 ! </p>
    </div>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        로 그 인
    </button>
    <!-- login form -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle"><b style="color: #da0808;">|&nbsp;</b>Member Login</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
                    <form method="POST" action="login.jsp" id="logincheck" onsubmit="return loginCheck();">
                      <div class="form-group">
                        <label class="main-id" for="loginEmail">아이디</label>
                        <input type="email" class="form-control" id="loginEmail" aria-describedby="emailHelp" placeholder="id" name="email">
                      </div>
                      
                      <div class="form-group">
                        <label class="main-pw" for="loginPassword">비밀번호</label>
                        <input type="password" class="form-control" id="loginPassword" placeholder="password" name="password">
                      </div>
                      <button type="submit" class="btn btn-secondary">L O G I N</button>
                    </form>
            </div>
          </div>
        </div>
    </div>
    <button type="button" class="btn btn-primary main-su" data-toggle="modal" data-target="#exampleModalLong">
        회 원 가 입
    </button>
    <!-- signup form -->
    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content sign">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle"><b style="color:#da0808;">|&nbsp;</b>Sign up</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
              <form method="POST" action="join.jsp" id="signupform" onsubmit="return signupcheck();">
                  <div class="form-group">
                      <label class="signup-id" for="joinEmail">아이디 (Email)</label>
                        <div class="idform-check">
                          <input type="email" class="form-control id" id="joinEmail" placeholder="email@example.com" name="joinEmail">
                          <button class="signup-id-check" type="button" onclick="checkEmail()">check</button>
                          <div class="checkcheck" id="idcheck"></div>
                        </div>
                  </div>
                  <div class="form-group">
                      <label class="signup-pw" for="password">비밀번호</label>
                      <input type="password" class="form-control" id="password" placeholder="password" name="password">
                      <input type="password" class="form-control confirm" id="passwordcheck" placeholder="confirm password" name="passwordcheck">
                  </div>
                  <div class="form-group">
                      <label class="signup-name" for="name">이름</label>
                      <input type="text" class="form-control" id="name" placeholder="name" name="name">
                  </div>
                  <button type="submit" class="btn btn-secondary" id="signup-btn">가 입 하 기</button>
              </form>
            </div>
            </div>
        </div>
    </div>
  </body>
</l:otherwise>
</l:choose>
  <div class="se-pre-con"></div>

  <script src="static/js/naver_map.js"></script>
  <script src="static/js/main.js"></script>
  <script src="static/js/get_playing_quest.js"></script>
  <script src="static/js/formcheck.js"></script>
</html>
