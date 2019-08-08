<%@ page import="board.PostDAO" %>
<%@ page import="board.PostVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  PostDAO dao = new PostDAO();
  int post_count = dao.findPostCountByUserId(request);

  request.setAttribute("post_count", post_count);


%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="theme-color" content="#999999" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>

  <title>MyPage</title>

  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1da8ruo4kk"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <link rel="stylesheet" href="static/css/main.css" />
  <script src="static/js/mypage.js"></script>
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="col-xs-12 back">
        <a href="index.jsp">
          <img src="static/img/back.png" width="20" height="20">
        </a>
      </div>
    </div>
    <div class="row user-row">
      <div class="user-container">
        <div class="thumb_area">
          <div class="thumb_img">
            <div class="mask" />
            <img src="static/img/avatar.png" class="thumb">
          </div>
          <p class="txt">
            <em class="name">Hyunmin Ko</em>
          </p>
          <p class="alias">
            <span class="name">오름 정복자</span>
          </p>
        </div>
      </div>
    </div>
    <div class="row quest-border">
      <p class="quest-title">Quest status</p>
    </div>
    <div class="row quest-status">
      <div class="quest-circle-container">
        <div class="quest-circle">
          <span class="quest-circle-innertext counter" data-count="142">0</span>
          <p class="quest-circle-title">획득 칭호 수</p>
        </div>
        <div class="quest-circle">
          <span class="quest-circle-innertext counter" data-count="512">0</span>
          <p class="quest-circle-title">해결한 퀘스트 수</p>
        </div>
        <div class="quest-circle">
          <span class="quest-circle-innertext counter" data-count="${post_count}">0</span>
          <p class="quest-circle-title">올린 게시글 수</p>
        </div>
      </div>
    </div>
    <div class="row quest-list">
      <p class="quest-title">Qeust Ing...</p>
      <ul class="quest-ul">
        <li>
          <div class="quest-card">
            <div class="quest-head">
              <img src="static/img/saebeyolorum.jpg" width=150 height=100/>
            </div>
            <div class="quest-body">
              <p class="title">새별오름</p>
            </div>
          </div>
        </li>
        <li>
          <div class="quest-card">
            <div class="quest-head">
              <img src="static/img/saebeyolorum.jpg" width=150 height=100/>
            </div>
            <div class="quest-body">
              <p class="title">새별오름</p>
            </div>
          </div>
        </li>
        <li>
          <div class="quest-card">
            <div class="quest-head">
              <img src="static/img/saebeyolorum.jpg" width=150 height=100/>
            </div>
            <div class="quest-body">
              <p class="title">새별오름</p>
            </div>
          </div>
        </li>
        <li>
          <div class="quest-card">
            <div class="quest-head">
              <img src="static/img/saebeyolorum.jpg" width=150 height=100/>
            </div>
            <div class="quest-body">
              <p class="title">새별오름</p>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>

</body>

</html>