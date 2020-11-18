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
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>Cafe Hub Modify</title>

	<script>
		function checkFile(file){
			
			let fileInfo = file.files;
			console.log(fileInfo);
			
			if(/\.(jpe|jpg|jpeg|png)$/i.test(fileInfo[0].name))
			{
				return;
			}
			else{
				alert("파일의 확장자를 확인해주세요!");
				file.outerHTML = file.outerHTML;
			}
		}
	
	</script>
</head>

<body>
	<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>
			<h3 id="editDesc">카페 프로필 수정하기</h3><br/>
			
			<div id="writeInfo">
				<h3 class="info">카페 기본 정보</h3><p>　>　</p><h3 class="presentInfo">메뉴판 사진</h3><p>　>　</p><h3 class="info">대표 사진</h3><p>　>　</p><h3 class="info">카페 소개 사진</h3>
			</div>
		<main>
			<form name="submitTest" method="post" action="OwnerModifyPicture.do" enctype="multipart/form-data">
			         <h2 id="cafeInfo">메뉴판</h2>
			         		<ul><li class="desc">메뉴판 사진을 업로드해주세요.</li></ul>
			                <ul><li class="desc">최대 3장 업로드 하실 수 있습니다.</li></ul>
			                <ul><li class="desc">사진의 크기는 최대 10MB를 넘을 수 없습니다.</li></ul>
			                <ul><li class="desc">지원되는 확장자 명: JPG, PNG, JPEG, JPE</li></ul>
<%

%>
			                <div id="showMenu" >
			                	<br/>
								<h4 class="menuInfo">첫번째 메뉴판 사진</h4>
									<c:if test="${myDTO.cafeMenu1 == '/CafeProject_10/UploadFolder_Owner/null'}">
										<ul><li class="desc">메뉴판 이미지가 없어요!</li></ul>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
									
									<c:if test="${myDTO.cafeMenu1 != '/CafeProject_10/UploadFolder_Owner/null'}">
										<img src="${myDTO.cafeMenu1 }" width= "231px" height="150px" alt="메뉴판 이미지1" > <br/>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
								
								
								<h4 class="menuInfo">두번째 메뉴판 사진</h4>
									<c:if test="${empty myDTO.cafeMenu2}">
										<ul><li class="desc">메뉴판 이미지가 없어요!</li></ul>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
									
									<c:if test="${not empty myDTO.cafeMenu2}">
										<p>dto: ${myDTO.cafeMenu2 }</p>
										<img src="${myDTO.cafeMenu2 }" width= "231px" height="150px" alt="메뉴판 이미지2" > <br/>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
									
									
								<h4 class="menuInfo">세번째 메뉴판 사진</h4>
									<c:if test="${empty myDTO.cafeMenu3}">
										<ul><li class="desc">메뉴판 이미지가 없어요!</li></ul>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
									
									<c:if test="${not empty myDTO.cafeMenu3}">
										<img src="${myDTO.cafeMenu3 }" width= "231px" height="150px" alt="메뉴판 이미지3" > <br/>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
								

			             	</div>
			             	
			             	
			             	
			       <input type="submit" value=" Next " id="writeBtn">
			       
			             
			</form>
			

		</main>
	<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>