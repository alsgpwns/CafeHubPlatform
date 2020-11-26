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
<link rel="stylesheet" type="text/CSS" href="../LoginPageCSS/Login.CSS">

<title>Cafe Hub Login</title>
</head>
<body>

<%@ include file="/IncludeFile/Header.jsp" %>
<script>
	function logInAction(index){
		if(index ==1){
			document.logInType.action="GuestLogin.do";
		}
		else if(index==2){
			document.logInType.action="OwnerLogin.do";
		}
	}
</script>
	<form method="post" name="logInType" id="loginform">
            <div id="idbox">
                   <input type="text" name="userId" placeholder='아이디' id="userID" required>
            </div>

            <div id="pwbox">
           			<input type="password" name="userPw" id="userPW" placeholder='비밀번호' required>
            </div>
	        <div id="GuestLoginBox">
	            <input type="submit" value="일반 로그인" id="generalLogin" onclick="logInAction(1)">
	        </div>
	        <div id="OwnerLoginBox">
	            <input type="submit" value="점주 로그인" id="ownerLogin" onclick="logInAction(2)">
	        </div>
	</form>

<%@ include file="/IncludeFile/Footer.jsp" %>

</body>
</html>