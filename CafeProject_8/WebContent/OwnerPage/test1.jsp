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
<title>Insert title here</title>
</head>
<body>
<script>

function checkFile()
{
      var fm  = document.fileForm;    
      var fnm = fm.uploadFile;
      var ext = fnm.value;

      if( !(ext.substr(ext.length-3) == 'jsp' || ext.substr(ext.length-3) == 'jpg'))
      {
            alert("jsp/jpg 파일만 올릴수 있습니다.");
            return false;
       }
       fm.submit();
}
</script>

<form name="fileForm" method="post" enctype="multipart/form-data" action="i.jsp">
      <input type="file" style="WIDTH: 320px" name="uploadFile" >
      <input type="button" value="File Upload" onclick="javascript:checkFile()">
</form>

</body>
</html>