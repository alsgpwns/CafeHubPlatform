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
<title>Cafe Hub Join</title>
</head>
<body>

<script>
	alert("비밀번호를 확인해주세요.");
</script>
<%	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage/JoinGuest.jsp");
	dispatcher.forward(request,response);
%>


</body>
</html>