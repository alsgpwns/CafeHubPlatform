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
stampCheck();
function stampCheck(){
           let answer;
           answer = confirm("확인 버튼을 누르시면, ${saveId}에게 ${saveStamp}개가 적립됩니다. ");
           //확인을 선택한 경우 자바스크립트를 호출할 때 같이 넘어온 url이라는 변수에 들어있는 주소로 페이지 이동
           if(answer == true){
               location = "ownerSaveStampOK.do";
           }
           else if(answer != true){
           	location = history.go(-1);
           }
       }
</script>
</head>
<body>

</body>
</html>