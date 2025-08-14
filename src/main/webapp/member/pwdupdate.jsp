<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='/css/member/pwdupdate.css'>
    <script src='/js/member/pwdupdate.js'></script>    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>    
    <div id="container">
        <h3> 비밀번호 수정 페이지 </h3>
        <div>현재 비밀번호 : <input type="text" class="oldpwd" id="oldpwd"/></div>
        <div>새 비밀번호 : <input type="text" class="newpwd" id="newpwd"/></div>        
        <button type="button" onclick="onPwdUpdate()"> 수정 </button>
    </div>
</body>
</html>