<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/StampPageCSS/ownerStampCSS.css" />" rel="stylesheet">

<title>Cafe Hub Stamp</title>
</head>
<body>
<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>
	<div id="MainArticle" >
	    <h3>스탬프 적립하기</h3>
	    <form method="post" action="ownerSaveStamp.do">
	        <label for="saveID" id="saveID"  class="saveTitle">아이디</label>
	        <input type="text" name="saveID" placeholder='아이디' maxlength="20" id="saveID" class="saveInput" required>
	
	        <label for="saveStamp" id="saveStamp"  class="saveTitle">스탬프</label>
	        <input type="text" name="saveStamp" placeholder='적립할 스탬프 갯수' maxlength="20" id="saveStamp" class="saveInput" required>
	
	        <input type="submit" value="적립" id="saveBtn">
	        <input type="reset" value="초기화" id="resetBtn">
	
	    </form>
	 </div>
 <%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>