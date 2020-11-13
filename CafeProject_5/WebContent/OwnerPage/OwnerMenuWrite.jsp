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
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<title>Cafe Hub Write</title>
<script>

	let MenuCnt=1;
	
	function showCosButton(MenuCnt){
	        text2='메뉴판2: <input type="file" name="menu2" class="menuBtn"  class="cafeInfo" ><br/>';
	        text3='메뉴판3: <input type="file" name="menu3" class="menuBtn"  class="cafeInfo" ><br/>';
	       
	    if(MenuCnt==1)
	    {
	       document.getElementById('showCos').innerHTML=text2;
	    }
	    else if(MenuCnt==2)
	    {
	       document.getElementById('showCos').innerHTML=text2+text3;
	    }
	    else if(MenuCnt>=3)
	    {
	       alert("사진은 최대 3장까지 업로드하실 수 있습니다.");
	    }
	    
	    MenuCnt=2;
	
	}
	

	function checkFile()
	{
	      let form = document.submitTest; 
	      
	      //메뉴 사진 1
	      let storeMenu1 = form.menu1;
	      let format1 = storeMenu1.value;
	      if(MenuCnt==1){
		      if( (format1.substr(format1.length-3) == 'jpg' || format1.substr(format1.length-3) == 'PNG' || format1.substr(format1.length-3) == 'JPEG' || format1.substr(format1.length-3) == 'JPE' || format1.substr(format1.length-3) == 'JPG' ) || format1=="" )
		      {  	
		    	  form.submit();
		      }else{
		            alert("파일의 확장자 명을 확인해주세요!");
		            return false;
		      }
	      }
	      else if(MenuCnt==2){
		      //메뉴 사진2
		      let storeMenu2 = form.menu2;
		      let format2 = storeMenu2.value;
		      if( (format1.substr(format1.length-3) == 'jpg' || format1.substr(format1.length-3) == 'PNG' || format1.substr(format1.length-3) == 'JPEG' || format1.substr(format1.length-3) == 'JPE' || format1.substr(format1.length-3) == 'JPG' ) || format1=="" ) && (format2.substr(format2.length-3) == 'jpg' || format2.substr(format2.length-3) == 'PNG' || format2.substr(format2.length-3) == 'JPEG' || format2.substr(format2.length-3) == 'JPE'  || format2.substr(format2.length-3) == 'JPG' ) )
		      {
		    	  form.submit();
		      }else{
		            alert("파일의 확장자 명을 확인해주세요!");
		            return false;
		      }
	      }
	      else if(MenuCnt==3){
		      //메뉴 사진2
		      let storeMenu3 = form.menu3;
		      let format3 = storeMenu3.value;
		      if( (format3.substr(format3.length-3) == 'jpg' || format3.substr(format3.length-3) == 'PNG' || format3.substr(format3.length-3) == 'JPEG' || format3.substr(format3.length-3) == 'JPE'  || format3.substr(format3.length-3) == 'JPG' ) )
		      {
		    	  form.submit();
		      }else{
		            alert("파일의 확장자 명을 확인해주세요!");
		            return false;
		      }
	      }
		      
		      
		    
	      
	      
	      
	      
	     
	}
	


</script>
</head>

<body>
	<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>
		<main>
			<div id="writeInfo">
				<h3 class="info">카페 기본 정보</h3><p>　>　</p><h3 class="presentInfo">메뉴판 사진</h3><p>　>　</p><h3 class="info">카페 사진</h3>
			</div>
			<form name="submitTest" method="post" action="OwnerPictureMenu.do" enctype="multipart/form-data">
			         <h2 id="cafeInfo">메뉴판</h2>
			         		<ul><li class="desc">메뉴판 사진을 업로드해주세요.</li></ul>
			                <ul><li class="desc">최대 3장 업로드 하실 수 있습니다.</li></ul>
			                <ul><li class="desc">사진의 크기는 최대 10MB를 넘을 수 없습니다.</li></ul>
			                <ul><li class="desc">지원되는 확장자 명: JPG, PNG, JPEG, JPE</li></ul>
			         		 메뉴판1: <input type="file" name="menu1" class="menuBtn"  class="cafeInfo" >
			
			             <input type="button" value=" + " onclick="showCosButton(MenuCnt++)">
			                
			                <div id="showCos" >
			
			             	</div>
			             	
			       <input type="button" value=" Next " id="writeBtn" onclick="checkFile()">
			       
			             
			</form>
			

		</main>
	<%@ include file="/IncludeFile/Footer.jsp" %>
</body>

</html>