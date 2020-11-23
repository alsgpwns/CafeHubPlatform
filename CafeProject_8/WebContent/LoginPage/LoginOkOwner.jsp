<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import ="com.www.hj.DTO.Board.DTOWriteOwner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Hyemoeng">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesehet" type="text/CSS" href="../LoginPageCSS/mainCSS.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&family=Roboto:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link href="<c:url value="../LoginPageCSS/mainCSS.css" />" rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>Cafe Hub</title>
</head>
<body>

<!-- 로그인 OK오너 -->
<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>

	<main>
	
		<c:forEach var="dto" items="${list}" >
		
			<section class="sectionBox">
			
				<article>
					<a href="#" class="imageFeature">
						<img src="${dto.cafeReprePicture }" width= "231px" height="150px" alt="카페 이미지" >
					</a>
					<div class="inner">
						 <b>${dto.cafeName }</b>
						 <p>${dto.cafeIntroduce }</p>
			             <p><i class="fab fa-gratipay"></i> ${dto.like }</p>
			             <p><i class="fas fa-map-marker-alt"></i> ${dto.cafeAddress }</p>
			              <p><i class="fas fa-clock"></i> ${dto.cafeHours }</p>
					</div>
				</article>
				
			</section>
			
		</c:forEach>
	</main>
<%@ include file="/IncludeFile/Footer.jsp" %>

</body>
</html>