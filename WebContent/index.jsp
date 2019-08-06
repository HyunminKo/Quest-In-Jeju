<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="theme-color" content="#999999" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
    <title>QuestInJeJu</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1da8ruo4kk"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
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
      			<button type="button" class="btn btn-outline-danger gothic">오름 정복하기 ( 2/5 )</button>
      		</a></div>


    <!--오름리스트-->
            <div class="container2" id="orumlist">
                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary gothic naming">새별오름</button>

                    <button type="button" class="btn btn-outline-danger gothic auth">인증</button>
                </div>

                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">거문오름</button>

                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>

                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary  naming">노로오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>

                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">노꼬메오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>
                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">느지리오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>
                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">다랑쉬오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>
                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">따라비오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>
                <div class="auth-wrap">
                    <button type="button" class="btn btn-outline-secondary naming">말미오름</button>
                    <button type="button" class="btn btn-outline-danger auth">인증</button>
                </div>
              </div><!--container2-->






        <!--맛집 리스트-->
      		<div class="button"><a href="javascript:doDisplayf();">
      			<button type="button" class="btn btn-outline-danger gothic">맛집 정복하기 ( 2/5 )</button>
            </a>	</div>

          <div class="container3" id="foodlist">
              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary gothic naming">새별오름</button>

                  <button type="button" class="btn btn-outline-danger gothic auth">인증</button>
              </div>

              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">거문오름</button>

                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>

              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary  naming">노로오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>

              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">노꼬메오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>
              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">느지리오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>
              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">다랑쉬오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>
              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">따라비오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>
              <div class="auth-wrap">
                  <button type="button" class="btn btn-outline-secondary naming">말미오름</button>
                  <button type="button" class="btn btn-outline-danger auth">인증</button>
              </div>
            </div><!--container3-->



            <!--산책 리스트-->
              <div class="button"><a href="javascript:doDisplayw();">
                <button type="button" class="btn btn-outline-danger gothic">산책로 정복하기 ( 2/5 )</button>
                </a>	</div>

              <div class="container4" id="walklist">
                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary gothic naming">새별오름</button>

                      <button type="button" class="btn btn-outline-danger gothic auth">인증</button>
                  </div>

                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">거문오름</button>

                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>

                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary  naming">노로오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>

                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">노꼬메오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>
                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">느지리오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>
                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">다랑쉬오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>
                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">따라비오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>
                  <div class="auth-wrap">
                      <button type="button" class="btn btn-outline-secondary naming">말미오름</button>
                      <button type="button" class="btn btn-outline-danger auth">인증</button>
                  </div>
                </div><!--container4-->




      		<div class="button">
      			<button type="button" class="btn btn-outline-danger gothic">산책로 정복하기 ( 2/5 )</button>
      		</div>
      		<div class="button">
      			<button type="button" class="btn btn-outline-danger gothic">카페 정복하기 ( 2/5 )</button>
      		</div>
      		<div class="button">
      			<button type="button" class="btn btn-outline-danger gothic">바다 정복하기 ( 1/5 )</button>
      		</div>
      		<div class="button">
      			<button type="button" class="btn btn-outline-danger gothic">오름 정복하기 ( 2/5 )</button>
      		</div>
      	</div><!--container-->



  </body>
</html>
