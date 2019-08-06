<%--
  User: hyunminko
  Date: 2019-08-06
  Time: 12:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="static/css/main.css" />
    <script src="static/js/main.js"></script>
</head>
<body>
<div class="nav">
    <div id="menu" class="menu">
        <a class="navbar-brand" href="#" id="link_1" onclick="showStateIcons(this)">
            <img id="img_1" src="static/img/placeholder.png" width="30" height="30" alt=""/>
        </a>
        <a class="navbar-brand" href="#" id="link_2" onclick="showStateIcons(this)">
            <img id="img_2" src="static/img/flag.png" width="30" height="30" alt=""/>
        </a>
        <a class="navbar-brand" href="mypage.jsp" id="link_3" onclick="showStateIcons(this)">
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
</body>
</html>
