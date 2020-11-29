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
<title>Insert title here</title>
	<script>
	wishList();
	 function wishList(){
	            var answer;
	            let type="${writingType}";
	           
	            let NoUrl="/CafeProject_10/LoginPage/viewContents.do?type=${writingType}&id=${writingId}";
	          
	            answer = confirm("찜 목록에 담겼어요! 찜 목록을 확인할까요?");
	            //확인을 선택한 경우 자바스크립트를 호출할 때 같이 넘어온 url이라는 변수에 들어있는 주소로 페이지 이동
	            if(answer == true && type == "owner"){
	                location = "/CafeProject_10/LoginPage/viewOwnerWishList.do";
	            }
	            else if(answer == true && type == "guest"){
	            	location = "/CafeProject_10/LoginPage/viewGuestWishList.do";
	            }
	            else if(answer != true){
	            	location = NoUrl;
	            }
	        }
	       
	</script>

</head>
<body>
	
	
</body>
</html>