<%@ page import="quest.QuestDAO" %>
<%@ page import="quest.QuestVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="quest.QuestItemVO" %>
<%@ page import="quest.QuestItemDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.Utils" %>
<%@ page import="relation.UserQuestPlayDAO" %>
<%@ page import="relation.UserQuestPlayVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<%
  String userId = Utils.getValueInCookie(request,"user_id");

  QuestDAO questDAO = new QuestDAO();
  QuestItemDAO questItemDAO = new QuestItemDAO();

  Map<Long,String> questNameMap = questDAO.getQuestNameMap();
  List<QuestVO> questVOList = questDAO.findAll();

  List<QuestItemVO> questItemVOList = questItemDAO.findAll();

  Map<Long,List<QuestItemVO>> questItemMap = new HashMap<>();
  for(QuestItemVO vo : questItemVOList) {
    Long questId = vo.getQuest_id();
    if(!questItemMap.containsKey(questId)){
      questItemMap.put(questId,new ArrayList<QuestItemVO>());
    }
    questItemMap.get(questId).add(vo);
  }
  Map<Long,String> playingQuestMap = new HashMap<>();
  if(userId != null){
    UserQuestPlayDAO dao = new UserQuestPlayDAO();
    List<UserQuestPlayVO> list = dao.findPlayingQuestByUserId(Long.parseLong(userId));
    for(UserQuestPlayVO vo: list){
      playingQuestMap.put(vo.getQuest_id(),"playing");
    }
  }
  request.setAttribute("playingQuestMap",playingQuestMap);
  request.setAttribute("user_id",userId);
  request.setAttribute("questItemMap",questItemMap);
  request.setAttribute("questNameMap",questNameMap);
  request.setAttribute("questVOList",questVOList);
  request.setAttribute("questItemVOList",questItemVOList);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>

    <title>Quest</title>

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
  <%--<l:forEach var="row" items="${questVOList}">--%>
  <div class="container quest-main">
      <div class="container-quest">
        <l:forEach var="row" items="${questVOList}">
          <div class="que_box">
            <p class="que_conq_title">
              <img src ='static/img/quest.png' width="30" height="30">
              ${row.name}
              <!-- 큰 quest의 id를 <div>의 id로 주고, button을 클릭할 때 onclick 인자로 quest id를 보냅니다 -->
              <l:set var="quest_id" value="${row.id}"/>
              <l:choose>
                <l:when test="${playingQuestMap[quest_id] ne 'playing'}">
                  <button type="button" class="btn btn-outline-success btn-sm que_start_btn" onclick=confirm_user_accept(${row.id},${user_id})>
                    시작
                  </button>
                </l:when>
                <l:otherwise>
                  <button type="button" class="btn btn-outline-danger btn-sm que_start_btn" >
                    수행중
                  </button>
                </l:otherwise>
              </l:choose>
            </p>
          <div>
          <ul class="que_next">
            <l:forEach var="questItemVO" items="${questItemVOList}">
              <l:if test="${questItemVO.quest_id eq row.id}">
                <li class="que_list">
                  <div class="que_item" onclick="insertDataToModal(${questItemVO.id})" data-toggle="modal" data-target="#exampleModalCenter">
                    <div class="cover">
                      <img src= '${questItemVO.fileSystemName}' style="width: 100%; height: 100%;">
                    </div>
                    <div class="info">
                      <button type="button" class="btn-btn-primary" >
                        ${questItemVO.name}
                      </button>
                    </div>
                  </div>
                </li>
              </l:if>
            </l:forEach>
            </ul>
        </div>
        </div>
        </l:forEach>
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
        <div class="modal-img-container">
          <img id="modal-img" src=""/>
        </div>
        <div class="modal-body">
          <p id="modal-addr"></p>
          <p id="modal-content"></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn-btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>
</body>
<script>
  let questItemMap = {
  <l:forEach var="questItemVO" items="${questItemVOList}">
  "${questItemVO.id}": {
    name:"${questItemVO.name}",
    addr:"${questItemVO.addr}",
    description :"${questItemVO.description}",
    src: "${questItemVO.fileSystemName}"
  },
  </l:forEach>
}
  function insertDataToModal(id) {
    let item = questItemMap[id];
    $("#exampleModalCenterTitle").html("<b class='que_bold'>|&nbsp;</b>"+item['name']);
    $("#modal-addr").html(item['addr']);
    $("#modal-content").html(item['description']);
    $("#modal-img").attr("src",item['src']);
  }
</script>
<script src="static/js/main.js"></script>
<script src="static/js/accept_quest.js"></script>
<%--<!-- cors 를 해결하기 위해 추가해 봅니다 !! -->--%>
<%--<script src='https://poiemaweb.com/assets/data/data-jsonp.js'></script>--%>

</html>
