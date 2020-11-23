<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<title>Cafe Hub Write</title>
</head>
<body>
<script>
	function checkFile(file){
		
		let fileInfo = file.files;
		
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

<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>

<div id="writeInfo">
	<h3 class="info">카페 기본 정보</h3><p>　>　</p><h3 class="info">메뉴판 사진</h3><p>　>　</p><h3 class="presentInfo">카페 대표 사진</h3><p>　>　</p><h3 class="info">카페 사진</h3>
</div>

<main>
			<form name="submitTest" method="post" action="OwnerCafeReprePicture.do" enctype="multipart/form-data">
			         <h2 id="cafeInfo">카페 대표 사진</h2>
			         		<ul><li class="desc">카페 대표 사진을 업로드해주세요.</li></ul>
			                <ul><li class="desc">카페 대표 사진은 1장을 업로드 하실 수 있습니다.</li></ul>
			                <ul><li class="desc">사진의 크기는 최대 10MB를 넘을 수 없습니다.</li></ul>
			                <ul><li class="desc">지원되는 확장자 명: JPG, PNG, JPEG, JPE</li></ul><br/>
			                
			                <ul><li class="cafeDesc">Cafe 대표 사진</li></ul>
			         		 <p class="cafeDesc_pTag">카페 대표 사진: </p><input type="file" name="representative" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/><br/>
			         		 
			             	
			       <input type="submit" value=" Next " id="writeBtn">
			       
			             
			</form>
			

</main>

<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>