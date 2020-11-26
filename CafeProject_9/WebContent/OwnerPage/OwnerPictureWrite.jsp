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
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<title>Insert title here</title>
</head>
<body>
<script>

	let MenuCnt=1;
	
	function showCosButton(MenuCnt){
		
	        text2='<p class="cafeDesc_pTag">카페 사진2: </p><input type="file" name="picture2" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	        text3='<p class="cafeDesc_pTag">카페 사진3: </p><input type="file" name="picture3" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	        text4='<p class="cafeDesc_pTag">카페 사진4: </p><input type="file" name="picture4" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	        text5='<p class="cafeDesc_pTag">카페 사진5: </p><input type="file" name="picture5" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	        text6='<p class="cafeDesc_pTag">카페 사진6: </p><input type="file" name="picture6" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	        text7='<p class="cafeDesc_pTag">카페 사진7: </p><input type="file" name="picture7" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" ><br/>';
	       
	    if(MenuCnt==1)
	    {
	       document.getElementById('showCos').innerHTML=text2;
	    }
	    else if(MenuCnt==2)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3;
	    }
	    else if(MenuCnt==3)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3+text4;
	    }
	    else if(MenuCnt==4)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3+text4+text5;
	    }
	    else if(MenuCnt==5)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3+text4+text5+text6;
	    }
	    else if(MenuCnt==6)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3+text4+text5+text6+text7;
	    }
	    else if(MenuCnt>=7)
	    {
	       alert("사진은 최대 7장까지 업로드하실 수 있습니다.");
	    }
	
	}
	
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
		<h3 class="info">카페 기본 정보</h3><p>　>　</p><h3 class="info">메뉴판 사진</h3><p>　>　</p><h3 class="info">카페 대표 사진</h3><p>　>　</p><h3 class="presentInfo">카페 사진</h3>
	</div>
<main>
			<form name="submitTest" method="post" action="OwnerCafePicture.do" enctype="multipart/form-data">
			         <h2 id="cafeInfo">카페 사진</h2>
			         		<ul><li class="desc">카페 사진을 업로드해주세요.</li></ul>
			                <ul><li class="desc">카페 사진은 최대 7장을 업로드 하실 수 있습니다.</li></ul>
			                <ul><li class="desc">사진의 크기는 최대 10MB를 넘을 수 없습니다.</li></ul>
			                <ul><li class="desc">지원되는 확장자 명: JPG, PNG, JPEG, JPE</li></ul><br/>
			                
			         		 <ul><li class="cafeDesc">Cafe 소개 사진</li></ul>
			         		 <ul><li class="cafeDesc_mini">Cafe 내부사진, 외부사진, 음식사진 다 좋아요 :)</li></ul>
							 <p class="cafeDesc_pTag">카페 사진1: </p><input type="file" name="picture1" class="menuBtn"  class="cafeInfo" onchange="checkFile(this)" >
			             <input type="button" value=" + " onclick="showCosButton(MenuCnt++)">
			                
			                <div id="showCos" >
			
			             	</div>
			             	
			       <input type="submit" value=" Write " id="writeBtn">
			       
			             
			</form>
			

</main>
		
<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>