<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Hyemoeng">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Header.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<link rel="stylesheet" type="text/css" href="../LoginPageCSS/Join.css">
<title>Cafe Hub Join</title>
</head>
<body>
<%@ include file="/IncludeFile/Header.jsp" %>

  <div id="JoinForm" class="JoinForm">
        <p id="Joindesc"><i class="fas fa-heart"></i>10초만에 가입하고 쿠폰받기<i class="fas fa-heart"></i></p>
        <a href="JoinGuest.jsp" id="UserJoinButton">일반 회원 가입하기</a>
        <a href="JoinOwner.jsp" id="OwenrJoinButton">점주 회원 가입하기</a>
   </div>


<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>