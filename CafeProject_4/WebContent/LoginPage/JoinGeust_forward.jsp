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
<link rel="stylesheet" type="text/css" href="../LoginPageCSS/JoinGuest.css">

<title>Cafe Hub Join</title>
</head>
<body onload="reset()">

<%@ include file="/IncludeFile/Header.jsp" %>
 <Script>
 	alert("비밀번호를 확인해주세요.");
 	
	let likingType="";
	
	function hashTagOnclickFuntion(hashtag) {
		document.getElementById(hashtag).style.backgroundColor="rgb(243, 196, 204)";
    	likingType=likingType+hashtag+",";
    	console.log(likingType);
    }
    
    function hashTag() {
    	console.log(likingType);
    	document.Joinfrm.action="JoinGuest.do";
    	document.Joinfrm.hashtag.value=likingType;
    	document.Joinfrm.method="post";
    	document.Joinfrm.submit();
    }
    
    function idCheck() {
    	window.open("idcheckForm.jsp","idCheckForm","width=400, height=300");
    }
    
    function reset() {
        likingType="";
    }
    
</Script>

<div id="MainArticle" >
    <h3>회원 가입하기</h3>
               <form name="Joinfrm" id="JoinForm">

                   <div id="JoinBox">
                       <div id="idBox">
                           <label for="userID" id="id" class="JoinTitle" >아이디</label>
                           <input type="text" name="userId" placeholder='아이디' id="userId" class="JoinInput" value="${userId}" required readonly>
                           <ul>
                               <li id="descId" class="Joindesc">아이디는 5글자 이상 10글자 이하,</li>
                               <li id="descId" class="Joindesc">영어와 숫자 조합만 가능합니다.</li>
                           </ul>
                           <a href="#" id="CertifyID" onclick="idCheck()">중복 확인</a>
                       </div>

                       <label for="userPw" id="pwBox"  class="JoinTitle">비밀번호</label>
                           <input type="password" name="userPw" placeholder='비밀번호(8~20자리)' maxlength="20" id="userPw" class="JoinInput" required>
                           <input type="password" name="userPwCheck" placeholder='비밀번호 재입력'  maxlength="20" id="userPwCheck" class="JoinInput" required>
                   </div>

                   <div id="PermissionBox">

                       <div id="PhoneNumber" class="JoinTitle">전화 번호</div>
                       <select id="countryNumber" name="countryNumber">
                           <option value="82">+82  Public of Korea</option>
                           <option value="81">+81  Japan</option>
                           <option value="86">+86 China</option>
                           <option value="374">+374 America</option>
                       </select>
                       <input type="text" name="userPoneNumber" id="userPhoneNum" class="JoinInput" value="${userPhoneNumber }" placeholder="전화번호" required>
                       <a href="#" id="CertifyNumber">인증번호 전송</a>
                   </div>

                   <label for="UserEmail" id="Email" class="JoinTitle">이메일</label>
                   <input type="text" name="UserEmail" placeholder='이메일' id="UserEmail" value="${UserEmail}" class="JoinInput" required>

                   <div id="likingBox">
                       <a href="#1" class="hashtag" id="puppy" value=""  onclick="hashTagOnclickFuntion('puppy')">#애견동반</a>
                       <a href="#2" class="hashtag" id="flex" onclick="hashTagOnclickFuntion('flex')">#FLEX</a>
                       <a href="#3" class="hashtag" id="decafe" onclick="hashTagOnclickFuntion('decafe')">#디카페인</a>
                       <a href="#4" class="hashtag" id="pink"  onclick="hashTagOnclickFuntion('pink')">#핑크핑크</a>
                       <a href="#5" class="hashtag" id="wine"  onclick="hashTagOnclickFuntion('wine')">#와인한잔</a>
                       <a href="#6" class="hashtag" id="bakery"  onclick="hashTagOnclickFuntion('bakery')">#베이커리</a>
                       <a href="#7" class="hashtag" id="smoke"  onclick="hashTagOnclickFuntion('smoke')">#흡연부스</a>
                       <a href="#8" class="hashtag" id="drip"  onclick="hashTagOnclickFuntion('drip')">#핸드드립</a>
                       <a href="#9" class="hashtag" id="insta"  onclick="hashTagOnclickFuntion('insta')">#인☆갬성</a>
                       <a href="#10" class="hashtag" id="croffle"  onclick="hashTagOnclickFuntion('croffle')">#크로플</a>
                   </div>
                   
                   <input type="hidden" name="hashtag" >
        
               <input type="submit" id="JoinGuest" value="가입하기" onclick="hashTag()">
       
               </form>    
 </div>


<%@ include file="/IncludeFile/Footer.jsp" %>

</body>
</html>