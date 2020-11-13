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
<script>
    let likingType="";
    let puppyNum =1;
    let flexNum =1;
    let decafeNum=1;
    let pinkNum=1;
    let bakeryNum=1;
    let wineNum=1;
    let smokeNum=1;
    let dripNum=1;
    let croffleNum=1;
    let instaNum=1;

    console.log(Filecnt);
    function hashTagOnclickFuntion(hashtag,count) {
	    count++;
	    console.log("hashtag: "+hashtag);
	    if(count%2==0){
	        likingType=likingType+hashtag+",";
	        document.getElementById(hashtag).style.backgroundColor="rgb(243, 196, 204)";
	    } else{
	        console.log("else");
	        likingType=likingType.replace(hashtag,"");
	        likingType=likingType.replace(/,,/,",");
	        document.getElementById(hashtag).style.backgroundColor="#e6e3e3";
	    }
	        
	    console.log("likingType: "+likingType);
	    console.log("count: "+count);
    }
    
    function submitFunction() {
        document.CosFrom.hashtag.value=likingType;
        document.CosFrom.submit();
        document.CosForm.action="cosForm.do";
        document.CosForm.method="post";
    }

</script>


<title>Cafe Hub Write</title>
</head>
<body>

<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>
  <main>
 		<div id="writeInfo">
			<h3 class="presentInfo">카페 기본 정보</h3><p>　>　</p><h3 class="info">메뉴판 사진</h3><p>　>　</p><h3 class="info">카페 사진</h3>
		</div>
        <form  name="CosFrom" action="OwnerText.do">
            <h2 id="cafeInfo">카페 정보</h2>
                카페 이름: <input type="text" name="cafeName" class="cafeInfo" id="cafeName"required placeholder=' 카페 이름 (필수)'><br/>
                전화 번호: <input type="text" name="cafeNumber" class="cafeInfo" id="cafeNumber" placeholder=' 전화 번호' ><br/>
                대표 메뉴: <input type="text" name="cafeMenu" class="cafeInfo" id="cafeMenu" required required placeholder=' 대표 메뉴 (필수)'><br/>
                가격대: <select name="price" id="selectPrice">
                    <option>1만원</option>
                    <option>2만원</option>
                    <option>3만원</option>
                    <option>4만원</option>
                    <option>5만원 이상</option>
                    </select>
                <br/>
                주차: <input type="text" name="cafeParking" class="cafeInfo" id="cafeParking" placeholder=' 주차'><br/>
                영업 시간: <input type="text" name="cafeOpen" class="cafeInfo" id="cafeOpen" required placeholder=' Open (필수)'>
                    <select name="openHour" id="selectHour">
                        <option>AM</option>
                        <option>PM</option>
                    </select> 
                     ~ <input type="text" name="cafeClose" class="cafeInfo" id="cafeClose" required placeholder=' Close (필수)'>
                    <select name="CloseHour">
                        <option>PM</option>
                        <option>AM</option>
                    </select> 
                <br/>
                쉬는 시간:  <input type="text" name="BreakStart" class="cafeInfo" id="BreakStart"  placeholder=' HH:MM'>
                    <select name="BreakStartHour" id="selectHour">
                        <option>PM</option>
                        <option>AM</option>
                    </select> 
                    ~ <input type="text" name="BreakEnd" class="cafeInfo" id="BreakEnd"  placeholder='  HH:MM'>
                    <select name="BreakEndHour">
                        <option>PM</option>
                        <option>AM</option>
                    </select> 
                <br/>
                마지막 주문: <input type="text" name="lastOrder" class="cafeInfo" id="lastOrder"  placeholder=' HH:MM'>
                    <select name="SelectLastOrder" id="SelectLastOrder">
                        <option>PM</option>
                        <option>AM</option>
                    </select> 
                <br/>
                한줄 카페 소개: <input type="text" name="cafeIntroduce" class="cafeInfo" id="cafeIntroduce" placeholder=' 한줄 소개 (필수)'><br/><hr/>
           
            <h3 id="hashTag">Hash Tag</h3>
            <div id="likingBox">
                <a href="#1" class="hashtag" id="puppy"  onclick="hashTagOnclickFuntion('puppy',puppyNum++)">#애견동반</a>
                <a href="#2" class="hashtag" id="flex" onclick="hashTagOnclickFuntion('flex',flexNum++)">#FLEX</a>
                <a href="#3" class="hashtag" id="decafe" onclick="hashTagOnclickFuntion('decafe',decafeNum++)">#디카페인</a>
                <a href="#4" class="hashtag" id="pink"  onclick="hashTagOnclickFuntion('pink',pinkNum++)">#핑크핑크</a>
                <a href="#5" class="hashtag" id="wine"  onclick="hashTagOnclickFuntion('wine',wineNum++)">#와인한잔</a>
                <a href="#6" class="hashtag" id="bakery"  onclick="hashTagOnclickFuntion('bakery',bakeryNum++)">#베이커리</a>
                <a href="#7" class="hashtag" id="smoke"  onclick="hashTagOnclickFuntion('smoke',smokeNum++)">#흡연부스</a>
                <a href="#8" class="hashtag" id="drip"  onclick="hashTagOnclickFuntion('drip',dripNum++)">#핸드드립</a>
                <a href="#9" class="hashtag" id="insta"  onclick="hashTagOnclickFuntion('insta',instaNum++)">#인☆갬성</a>
                <a href="#10" class="hashtag" id="croffle"  onclick="hashTagOnclickFuntion('croffle',croffleNum++)">#크로플</a>
            </div>
            
            <input type="hidden" name="hashtag">
            <input type="hidden" name="hiddenFileCnt">


            <input type="submit" value=" Next " id="writeBtn" onclick="submitFunction()">
        </form>
    </main>
<%@ include file="/IncludeFile/Footer.jsp" %>
</body>
</html>