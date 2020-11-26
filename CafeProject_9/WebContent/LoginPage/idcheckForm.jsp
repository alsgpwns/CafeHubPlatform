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
</head>
<body>

	<h3> 아이디 중복체크 </h3>
	<form method="post" action="idCheckOk.jsp" onsubmit="return IDCheck(this)">
		아이디 : <input type="text" name="personName" maxlength="10" autofocus required>
		<input type="submit" value="중복확인">
	</form>

<script>
function IDCheck(id){
	const userID = id.personName.value;
 	console.log(userID);
    let check=true;

    for(let i=0; i<userID.length; i++)
    {
        let temp = userID.charCodeAt(i);
        if( (65<=temp && temp<=90 || 97<=temp && temp<=122 || 48<=temp && temp<=57)&&userID.length>=5 && userID.length<=15 )  {
            console.log(temp);
        }
        else{
            check=false;
            break;
        }
    }
    if(check==false)
    {
        alert('사용하실 수 없는 아이디입니다.');
    }

    return check;
}
</script>
</body>
</html>