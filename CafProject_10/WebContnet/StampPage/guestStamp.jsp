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
<link rel="stylesheet" type="text/css" href="../StampPageCSS/guestStampCSS.css">
<link rel="stylesheet" type="text/CSS" href="../includeFileCSS/LoginOkHeader.css">
<link href="<c:url value="/IncludeFileCSS/LoginOkHeader.css" />" rel="stylesheet">
<title>cafe Hub Stamp</title>
</head>
<body>
<%@ include file="../IncludeFile/LoginOkHeader.jsp" %>
<main>

	<c:forEach var="dto" items="${stampList}" >
	
		<section class="sectionBox">
            <article>
                <a href="viewContents.do?id=test&type=owner" class="imageFeature">
                    <img src="${dto.cafeReprePicture }" width= "231px" height="150px" alt="카페 이미지" >
                </a>
                <div class="inner">
                     <b>${dto.cafeName}</b>
                     <p class="stampDesc" id="myStamp"><i class="fas fa-stamp"></i> 보유한 스탬프 갯수: 10 <i class="fas fa-stamp"></i></p>
                     <p class="stampDesc">사용할 갯수: 
                     <select name="stampNum">
                        <option value="5">5개</option>
                        <option value="10">10개</option>
                        <option value="15">15개</option>
                        <option value="20">20개</option>
                    </select><input type="button" value="사용" id="useBtn"></p>
                    <p>benefit♥</p>
                    <p>5개:${dto.stamp5} 　10개:${dto.stamp10} 　15개:${dto.stamp15} 　20개:${dto.stamp20}　</p>
                </div>

            </article>
            
        </section>
		
	</c:forEach>
</main>
<%@ include file="../IncludeFile/Footer.jsp" %>
</body>
</html>