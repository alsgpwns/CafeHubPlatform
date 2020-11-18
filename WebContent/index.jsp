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
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>Cafe Hub</title>

 	<style>
        body{  
            background-repeat:no-repeat;
            background-size: 99.9% 132%;
            background-position: center;
        }
        div{
            padding: 10px;
            width: 99%;
            height: 900px;
            cursor: pointer;
            text-align: center;
            color: black;
        }
    </style>
	
	<script>

        var arr = new Array();  //배경이미지를 배열로 저장
        arr[0]="./imgs/main.gif" ;
        arr[1]="./imgs/main1.gif" ;
        arr[2]="./imgs/main2.gif" ;
        arr[3]="./imgs/main3.gif" ;
        arr[4]="./imgs/main4.gif";
        arr[5]="./imgs/main5.gif";
        let imgNum = Math.round(Math.random()*5);

        window.onload = function()
        {
            document.body.style.backgroundImage = "url(./imgs/main.gif)";
            
        }
        
    </script>
</head>
<body>



    <div onclick="location.href='index.do'">
        <h2>솔직한 리뷰, 편리한 쿠폰북, 간편한 사이렌 오더까지!</h2>
        <h1><i class="fas fa-coffee"></i> Cafe Hub</h1>
    </div>


</body>
</html>