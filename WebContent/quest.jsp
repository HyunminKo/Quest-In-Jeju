<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>

    <title>Quest</title>

    <!-- ajax를 위해서 주석 처리 해봅니다 -->
    <!--script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
    <link rel="stylesheet" type="text/css" href="static/css/quest_page2.css">
    <link rel="stylesheet" href="static/css/main.css" />

</head>
<body>
  <%@include file="header.jsp" %>
  <div class="container quest-main">
      <div class="container-quest">
        <div class="que_box">
          <p class="que_conq_title">
            <img src ='static/img/quest.png' width="30" height="30">
            오름 정복하기
            <!-- 큰 quest의 id를 <div>의 id로 주고, button을 클릭할 때 onclick 인자로 quest id를 보냅니다 -->
            <button type="button" class="btn btn-outline-danger btn-sm que_start_btn" onclick=confirm_user_accept("1")>
              start
            </button>
          </p>
        <div>
          <ul class="que_next">
            <li class="que_list">
              <div class="item">
                <div class="cover">
                  <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                </div>
                <div class="info">
                  <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    새별오름
                  </button>
                </div>
              </div>
            </li>
            <li class="que_list">
                <div class="item">
                  <div class="cover">
                    <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                  </div>
                  <div class="info">
                    <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                      새별오름
                    </button>
                  </div>
                </div>
              </li>
              <li class="que_list">
                  <div class="item">
                    <div class="cover">
                      <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                    </div>
                    <div class="info">
                      <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                        새별오름
                      </button>
                    </div>
                  </div>
                </li>
                <li class="que_list">
                    <div class="item">
                      <div class="cover">
                        <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                      </div>
                      <div class="info">
                        <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                          새별오름
                        </button>
                      </div>
                    </div>
                  </li>
            </ul>
        </div>
        </div>
        <div class="que_box">
            <p class="que_conq_title">
              <img src ='static/img/quest.png' width="30" height="30">
              오름 정복하기
              <button type="button" class="btn btn-outline-danger btn-sm que_start_btn"
              onclick=confirm_user_accept("1")>
              start
            </button>
            </p>
          <div>
            <ul class="que_next">
              <li class="que_list">
                <div class="item">
                  <div class="cover">
                    <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                  </div>
                  <div class="info">
                    <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                      새별오름
                    </button>
                  </div>
                </div>
              </li>
              <li class="que_list">
                  <div class="item">
                    <div class="cover">
                      <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                    </div>
                    <div class="info">
                      <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                        새별오름
                      </button>
                    </div>
                  </div>
                </li>
                <li class="que_list">
                    <div class="item">
                      <div class="cover">
                        <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                      </div>
                      <div class="info">
                        <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                          새별오름
                        </button>
                      </div>
                    </div>
                  </li>
                  <li class="que_list">
                      <div class="item">
                        <div class="cover">
                          <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                        </div>
                        <div class="info">
                          <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                            새별오름
                          </button>
                        </div>
                      </div>
                    </li>
              </ul>
          </div>
        </div>
        <div class="que_box" id="1">
          <p class="que_conq_title">
            <img src ='static/img/quest.png' width="30" height="30">
            오름 정복하기
            <button type="button" class="btn btn-outline-danger btn-sm que_start_btn" onclick=confirm_user_accept("1")>
            start
          </button>
          </p>
        <div>
          <ul class="que_next">
            <li class="que_list">
              <div class="item">
                <div class="cover">
                  <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                </div>
                <div class="info">
                  <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    새별오름
                  </button>
                </div>
              </div>
            </li>
            <li class="que_list">
                <div class="item">
                  <div class="cover">
                    <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                  </div>
                  <div class="info">
                    <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                      새별오름
                    </button>
                  </div>
                </div>
              </li>
              <li class="que_list">
                  <div class="item">
                    <div class="cover">
                      <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                    </div>
                    <div class="info">
                      <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                        새별오름
                      </button>
                    </div>
                  </div>
                </li>
                <li class="que_list">
                    <div class="item">
                      <div class="cover">
                        <img src= 'static/img/orum.jpg' style="width: 100%; height: 100%;">
                      </div>
                      <div class="info">
                        <button type="button" class="btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                          새별오름
                        </button>
                      </div>
                    </div>
                  </li>
            </ul>
        </div>
      </div>
      </div>
  </div>
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenterTitle"><b class="que_bold">|&nbsp;</b>새별오름</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            When text is rendered by a computer, sometimes there will be characters in the text that can not be displayed, because no font that supports them is available to the computer. When this occurs, small boxes are shown to represent the characters. We call those small boxes “tofu,” and we want to remove tofu from the Web. This is how the Noto font families got their name.
            Noto helps to make the web more beautiful across platforms for all languages. Currently, Noto covers over 30 scripts, and will cover all of Unicode in the future. This is the Sans Khmer family. It has Regular and Bold styles and is hinted.
            Noto fonts are intended to be visually harmonious across multiple languages, with compatible heights and stroke thicknesses. For the currently released Noto fonts see code.google.com/p/noto/
            Link 아무말 대잔치
        </div>
        <div class="modal-footer">
          <button type="button" class="btn-btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>
</body>
<script src="static/js/main.js"></script>
<script src="static/js/accept_quest.js"></script>
<%--<!-- cors 를 해결하기 위해 추가해 봅니다 !! -->--%>
<%--<script src='https://poiemaweb.com/assets/data/data-jsonp.js'></script>--%>

</html>
