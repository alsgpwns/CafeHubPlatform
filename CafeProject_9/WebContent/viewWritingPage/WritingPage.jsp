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
<link rel="stylesheet" type="text/CSS" href="/CafeProject_10/viewWritingPageCSS/WritingPageCss.css">
<title>Cafe Hub</title>
</head>

<body>
<%@ include file="../IncludeFile/Header.jsp" %>
    <main>
     	<img src="${showDTO.cafeReprePicture }" class="viewImg">
     		<a href="iLikeIt.do" id="heart"><i class="fas fa-heart"></i></a>
		 <h1 id="cafeName">${showDTO.cafeName }</h1>
    
    
	    <section>
	        <hr>
			<h4 class="menuInfo">카페 한줄 소개</h4> <h4 class="cafeInfo" id="intro">${showDTO.cafeIntroduce}</h4><br/>
	        <h4 class="menuInfo">주소</h4> <h4 class="cafeInfo" id="adr">${showDTO. cafeAddress}</h4><br/>
	        <h4 class="menuInfo">전화번호</h4> <h4 class="cafeInfo" id="number">${showDTO.cafeNumber  }</h4><br/>
	        <h4 class="menuInfo">가격대</h4> <h4 class="cafeInfo" id="price">${showDTO.cafePrice  }</h4><br/>
	       	<h4 class="menuInfo">주차</h4> <h4 class="cafeInfo" id="parking">${showDTO.cafeParking  }</h4><br/>
	        <h4 class="menuInfo">영업시간</h4>
	         <c:if test="${ showDTO.cafeBreakeTime != 'PM PM'}">
	        	<h4 class="cafeInfo" id="break">${showDTO.cafeBreakeTime  }</h4>
	        </c:if>
	        <h4 class="menuInfo">쉬는시간</h4> <h4 class="cafeInfo" id="break">${showDTO.cafeBreakeTime  }</h4>
	        <hr>
	    </section>
    </main>
    <nav>
        <h3 class="menuDesc">메뉴판</h3>
        <c:if test="${showDTO.cafeMenu1 !='/CafeProject_10/UploadFolder_Owner/null' }">
	        <img src="${showDTO.cafeMenu1 }" class="viewImg">
        </c:if>
        <img src="${showDTO.cafeMenu2 }" class="viewImg">
        <img src="${showDTO.cafeMenu3 }" class="viewImg">
        <c:if test="${showDTO.cafeMenu1 =='/CafeProject_10/UploadFolder_Owner/null' &&  empty showDTO.cafeMenu2 &&  empty showDTO.cafeMenu3}">
       		<p> 메뉴판 사진이 없어요! :( </p>
        </c:if>
    </nav>

      <article>
        <h3 class="menuDesc">카페 사진</h3>
        <c:if test="${showDTO.cafePicture1 != '/CafeProject_10/UploadFolder_Owner/null' }">
    	    pic1: <img src="${showDTO.cafePicture1 }" class="viewCafeImg" id="Img1">
    	</c:if>
        <c:if test="${not empty showDTO.cafePicture2}">
	        pic2: <img src="${showDTO.cafePicture2 }" class="viewCafeImg" id="Img2"> 
        </c:if>
        <c:if test="${not empty showDTO.cafePicture3}">
        	pic3: <img src="${showDTO.cafePicture3 }" class="viewCafeImg" id="Img3">
        </c:if>
        <c:if test="${not empty showDTO.cafePicture4}">
        	<img src="${showDTO.cafePicture4 }" class="viewCafeImg" id="Img4">
        </c:if>
        <a href="#" id=""><i class="fas fa-chevron-circle-right" id="slidBtn"></i></a>
        <!-- <a href="#" id="slidBtn"> > </a> -->

    </article>
    
    <%@ include file="../IncludeFile/Footer.jsp" %>
</body>
</html>