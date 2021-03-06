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
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/CSS" href="/CafeProject_10/viewWritingPageCSS/WritingPageCss.css">
<link rel="stylesheet" type="text/CSS" href="../LoginPageCSS/mainCSS.css"> 
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkHeader.css">
<title>Cafe Hub Wish List</title>
</head>
<body>
<%@ include file="/IncludeFile/LoginOkHeader.jsp" %>
<main>
	<h3>Wish List</h3>
	<c:forEach var="dto" items="${wishList}" >
	
		<section class="sectionBox">
		
			<article>
				<a href="viewContents.do?id=${dto.id }&type=default" class="imageFeature">
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