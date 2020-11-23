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
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
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
				<h3 class="info">카페 기본 정보</h3><p>　>　</p><h3 class="info">메뉴판 사진</h3><p>　>　</p><h3 class="presentInfo">대표 사진</h3><p>　>　</p><h3 class="info">카페 소개 사진</h3>
			</div>
		<main>
			<form name="submitTest" method="post" action="OwnerModifyPicture.do" enctype="multipart/form-data">
			   	<div id="showMenu" >
			                	<br/>
								<h4 class="menuInfo">카페 대표 사진</h4>
									<c:if test="${myDTO.cafeReprePicture == 'null'}">
										<ul><li class="desc">대표 이미지가 없어요!</li></ul>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
									
									<c:if test="${myDTO.cafeReprePicture != 'null'}">
										<ul><li class="desc">수정하시려면 이미지를 업로드해주세요!</li></ul>
										<ul><li class="desc">수정을 원치 않으신다면 Next를 눌러주세요! :)</li></ul>
										<img src="${myDTO.cafeReprePicture }" width= "231px" height="150px" alt="대표 이미지" class="yourImg"> <br/><br/>
										<input type="file" name="menu1" class="menuInput" onchange="checkFile(this)" >
									</c:if>
						</div>
					<input type="submit" value=" Next " id="writeBtn">
				</form>
			</main>
		<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>