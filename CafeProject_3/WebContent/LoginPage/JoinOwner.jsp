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
<link rel="stylesheet" type="text/css" href="../LoginPageCSS/JoinOwner.css">

<title>Cafe hub Join</title>
</head>
<body>

<%@ include file="/IncludeFile/Header.jsp" %>

 <div id="MainArticle" >
                <h3>점주님 회원 가입하기</h3>
                <form id="JoinForm" method="post" action="JoinOwner.do">

                    <div id="JoinBox">
                        <div id="idBox">
                            <label for="userID" id="id" class="JoinTitle">아이디</label>
                            <input type="text" name="userId" placeholder='아이디' id="userID" class="JoinInput" required>
                            <ul>
                                <li id="descId" class="Joindesc">아이디는 영어와 숫자 조합으로 해주세요.</li>
                            </ul>
                            <a href="#" id="CertifyID">중복 확인</a>
                        </div>

                        <label for="userPw" id="pwBox"  class="JoinTitle">비밀번호</label>
                            <input type="password" name="userPw" placeholder='비밀번호(8~32자리)' id="userPw" class="JoinInput" required>
                            <input type="password" name="userPw" placeholder='비밀번호 재입력' id="userPwCheck" class="JoinInput" required>
                    </div>

                    <div id="PermissionBox">
                        <label for="permissionNumber" id="permissionBox" class="JoinTitle">사업자 등록 번호</label>
                        <input type="text" name="userPermission" placeholder='사업자 등록 번호' id="permissionNumber" class="JoinInput" required>

                        <div id="PhoneNumber" class="JoinTitle">전화 번호</div>
                        <select id="countryNumber" name="countryNumber">
                            <option value="82">+82  Public of Korea</option>
                            <option value="81">+81  Japan</option>
                            <option value="86">+86 China</option>
                            <option value="374">+374 America</option>
                        </select>
                        <input type="text" name="userPoneNumber" id="userPhoneNum" class="JoinInput" placeholder="전화번호" required>
                        <a href="#" id="CertifyNumber">인증번호 전송</a>
                        <ul>
                                <li id="descNumber" class="Joindesc">슬래쉬(-)를 제외하고 입력해주세요.</li>
                        </ul>
                    </div>

                    <label for="UserEmail" id="Email" class="JoinTitle">이메일</label>
                    <input type="text" name="UserEmail" placeholder='이메일' id="UserEmail" class="JoinInput" required>
                    
                    <label for="userName" id="userName" class="JoinTitle">이름</label>
                    <input type="text" name="userName" placeholder='아름(선택)' id="userName" class="JoinInput" required>
					
					
                	<input type="submit" id="JoinOwner" value="가입하기">
        
                </form>    
        </div>
<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>