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
<link rel="stylesheet" type="text/CSS" href="../IncludeFileCSS/LoginOkOwnerHeader.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&family=Roboto:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
        <div id="header" class="container">
            <div id="logo">
                <a href="/CafeProject_10/LoginPage/LoginOkOwner.jsp"><h1><i class="fas fa-coffee"></i> Cafe Hub</h1></a>
            </div>

           
            <a href="/CafeProject_10/OwnerPage/OwnerTextWrite.jsp" id="writebtn"><i class="far fa-edit" id="writeIcon"></i></a>
           

            <div class="dropdown">
                <button class="dropbtn"><i class="fas fa-user-edit"></i></button>
                    <div class="dropdown-content">
                        <a href="#">Your Cafe</a>
                        <a href="#">Your Profile</a>
                        <a href="#">Your WishList</a>
                        <a href="#">Your CouponBook</a>
                        <a href="signOut.do">Sign out</a>
                    </div>
            </div>
        </div>

        <div id="topbutton">
            <a href="#header" id="topbutton"><i class="fas fa-arrow-circle-up"></i></a>
        </div>
    </header>
</body>
</html>