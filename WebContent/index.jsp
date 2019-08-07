<%@ page contentType="text/html; charset=utf-8"
    import="java.util.List, quest.*"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
  /*
  Cookie[] cookies = request.getCookies();
  String userId = null;
  for( int i = 0 ; i < cookies.length ; i++ ) {
      if( ( "user_id" ).equals(cookies[i].getName()) ) {
          userId = cookies[i].getValue();
          break;
      }
  }
  //request.setAttribute(" ", );??/
  System.out.println(userId);
*/
	String userId = null;
	
	//request.setAttribute("userId",userId);
	
	//response.getAttribute("userId");
	//Object idtest = request.getAttribute("userId");
	
	 // System.out.println(idtest);//
	
	
  List<QuestItemVO> rl = null;
  List<QuestVO> rl2 = null;
	Exception err = null;


  QuestItemDAO dao = new QuestItemDAO();
  try{
  	rl = dao.findAll();
  	request.setAttribute("rl", rl);
  //	System.out.println(rl);
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

  	<link rel="stylesheet" href="static/css/quest_page.css"/>
    <link rel="stylesheet" href="static/css/main.css"/>
    <link rel="stylesheet" href="static/css/mainlogin.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  </head>
	<body>
	 <!--
    로그인 안했을때 보이는 부분  -->    

		    <%@include file="header.jsp" %>
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
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        로그인
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
                    <form>
                      <div class="form-group">
                        <label class="main-id" for="exampleInputEmail1">아이디</label>
                        <input type="id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="id">
                      </div>
                      
                      <div class="form-group">
                        <label class="main-pw" for="exampleInputPassword1">비밀번호</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password">
                      </div>
                      <button type="submit" class="btn btn-secondary">L O G I N</button>
                    </form>
            </div>
          </div>
        </div>
    </div>
    <button type="button" class="btn btn-primary main-su" data-toggle="modal" data-target="#exampleModalLong">
        회원가입
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
              <form method="POST" action="join.jsp" id="signupform" onsubmit="return check();">
                  <div class="form-group">
                      <label class="signup-id" for="exampleDropdownFormEmail2">아이디 (Email)</label>
                        <div class="idform-check">
                          <input type="email" class="form-control id" id="email" placeholder="email@example.com" name="email">
                          <button class="signup-id-check">check</button>
                        </div>
                  </div>
                  <div class="form-group">
                      <label class="signup-pw" for="exampleDropdownFormPassword2">비밀번호</label>
                      <input type="password" class="form-control" id="password" placeholder="password" name="password">
                      <input type="password" class="form-control confirm" id="passwordcheck" placeholder="confirm password" name="passwordcheck">
                  </div>
                  <div class="form-group">
                      <label class="signup-name" for="exampleDropdownFormEmail2">이름</label>
                      <input type="password" class="form-control" id="name" placeholder="name" name="name">
                  </div>
                  <button type="submit" class="btn btn-secondary" id="signup-btn" onclick>가입하기</button>
              </form>
            </div>
            </div>
        </div>
    </div>

	

  </body>
  <script src="static/js/naver_map.js"></script>
  <script src="static/js/main.js"></script>
  <script src="static/js/get_playing_quest.js"></script>
  <script src="static/js/formcheck.js"></script>
</html>

