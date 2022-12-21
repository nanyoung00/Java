<%--
  Created by IntelliJ IDEA.
  User: wwiwtb
  Date: 2022/12/18
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--responsive web--%>
    <meta name="viewport" content="width=device-width", initial-scale="1">
    <%--bootstrap reference--%>
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Bulletin Board System</title>
</head>
<body>
    <%--Navigation Bar header--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
        <a class="navbar-brand text-secondary" href="main.jsp">메뉴</a>
        <a class="navbar-brand text-secondary" href="bbs.jsp">게시판</a>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle"
                    type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">접속하기
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="login.jsp">로그인</a>
                <a class="dropdown-item" href="join.jsp">회원가입</a>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="jumbotron" style="padding-top: 50px;margin-top: 50px;">
                <form method="post" action="loginaction.jsp">
                    <h3 stype="text-align: center;">로그인 화면</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="로그인">
                </form>
            </div>
        </div>
    </div>
    <%--always use jquery latest ver--%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>
