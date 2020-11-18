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
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/Footer.css">
<link rel="stylesheet" type="text/CSS" href="../OwnerPageCSS/OwnerWriteCSS.css">
<title>Cafe Hub Modify</title>
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
    let view=1;
    let flower=1;
    let roof=1;

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

    }
</script>

</head>
<body>

<%@ include file="/IncludeFile/LoginOkOwnerHeader.jsp" %>
 		<div id="writeInfo">
 			<h3 id="editDesc">카페 프로필 수정하기</h3><br/>
			<h3 class="presentInfo">카페 기본 정보</h3><p>　>　</p><h3 class="info">메뉴판 사진</h3><p>　>　</p><h3 class="info">카페 사진</h3><p>　>　</p><h3 class="info">대표 사진</h3><p>　>　</p><h3 class="info">카페 소개 사진</h3>
		</div>
  <main>
        <form  name="CosFrom" action="OwnerTextModify.do">
            <h2 id="cafeInfo">카페 정보</h2>
                카페 이름: <input type="text" name="cafeName" class="cafeInfo" id="cafeName" value="${myDTO.cafeName }" placeholder=' 카페 이름 (필수)' required><br/>
                전화 번호: <input type="text" name="cafeNumber" class="cafeInfo" id="cafeNumber" value="${myDTO.cafeNumber }" placeholder=' 전화 번호' ><br/>
                대표 메뉴: <input type="text" name="cafeMenu" class="cafeInfo" id="cafeMenu" value="${myDTO.cafeMenu }" placeholder=' 대표 메뉴 (필수)' required><br/>
                가격대: <select name="price" id="selectPrice">
                    <option>1만원</option>
                    <option>2만원</option>
                    <option>3만원</option>
                    <option>4만원</option>
                    <option>5만원 이상</option>
                    </select>
                <br/>
                주차: <input type="text" name="cafeParking" class="cafeInfo" id="cafeParking" value="${myDTO.cafeParking }" placeholder=' 주차'><br/>
                영업 시간: <input type="text" name="cafeOpen" class="cafeInfo" id="cafeOpen" placeholder=' Open (필수)' required>
                    <select name="openHour" id="selectHour">
                        <option>AM</option>
                        <option>PM</option>
                    </select> 
                     ~ <input type="text" name="cafeClose" class="cafeInfo" id="cafeClose" placeholder=' Close (필수)' required>
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
                한줄 카페 소개: <input type="text" name="cafeIntroduce" class="cafeInfo"  value="${myDTO.cafeIntroduce }" id="cafeIntroduce" placeholder=' 카페 한줄 소개 (필수) (15자 최대)' maxlength="15" required>
                <br/>
                
                 위치: <input type="text" name="cafeAddress" id="sample5_address" value="${myDTO.cafeAddress }" class="cafeInfo" placeholder=' 위치 (필수)' required>
                <input type="button" onclick="sample5_execDaumPostcode()" value=" 주소 검색 "><br/>
                <div id="map" style="width:300px;height:300px;margin-top:10px;margin-left: 135px; margin-bottom: 15px;display:none"></div>
				
				<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3a6f4d6281494542265b1367c15021de&libraries=services"></script>
				<script>
				    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
				        mapOption = {
				            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
				            level: 5 // 지도의 확대 레벨
				        };
				
				    //지도를 미리 생성
				    var map = new daum.maps.Map(mapContainer, mapOption);
				    //주소-좌표 변환 객체를 생성
				    var geocoder = new daum.maps.services.Geocoder();
				    //마커를 미리 생성
				    var marker = new daum.maps.Marker({
				        position: new daum.maps.LatLng(37.537187, 127.005476),
				        map: map
				    });
				
				
				    function sample5_execDaumPostcode() {
				        new daum.Postcode({
				            oncomplete: function(data) {
				                var addr = data.address; // 최종 주소 변수
				
				                // 주소 정보를 해당 필드에 넣는다.
				                document.getElementById("sample5_address").value = addr;
				                // 주소로 상세 정보를 검색
				                geocoder.addressSearch(data.address, function(results, status) {
				                    // 정상적으로 검색이 완료됐으면
				                    if (status === daum.maps.services.Status.OK) {
				
				                        var result = results[0]; //첫번째 결과의 값을 활용
				
				                        // 해당 주소에 대한 좌표를 받아서
				                        var coords = new daum.maps.LatLng(result.y, result.x);
				                        // 지도를 보여준다.
				                        mapContainer.style.display = "block";
				                        map.relayout();
				                        // 지도 중심을 변경한다.
				                        map.setCenter(coords);
				                        // 마커를 결과값으로 받은 위치로 옮긴다.
				                        marker.setPosition(coords)
				                    }
				                });
				            }
				        }).open();
				    }
				</script>

                <hr/>
                
           
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
                <a href="#11" class="hashtag" id="roof"  onclick="hashTagOnclickFuntion('roof',roof++)">#루프탑</a>
                <a href="#12" class="hashtag" id="view"  onclick="hashTagOnclickFuntion('view',view++)">#전망좋은</a>
                <a href="#13" class="hashtag" id="flower"  onclick="hashTagOnclickFuntion('flower',flower++)">#플라워카페</a>
            </div>
            
            <input type="hidden" name="hashtag">
            <input type="hidden" name="hiddenFileCnt">


            <input type="submit" value=" Next " id="writeBtn" onclick="submitFunction()">
        </form>
    </main>
    
<%@ include file="/IncludeFile/Footer.jsp" %>


</body>
</html>