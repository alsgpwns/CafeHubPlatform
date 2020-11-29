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
	wishListDelete();
	function wishListDelete(){
		let answer;
		let type="${writingType}";
		answer = confirm("찜 목록에서 삭제할까요?");
		
		if(answer == true && type == "owner"){
            location = "OnwerDeleteWishList.do";
        }
        else if(answer == true && type == "guest"){
        	location = "GuestDeleteWishList.do";
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