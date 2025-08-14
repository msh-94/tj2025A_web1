<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='/css/member/find.css'>
    <script src='/js/member/find.js'></script>    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div>
            <h3> 아이디 찾기 </h3>
            <div> 이름 : <input type="text" class="mnameInput" id="mnameInput"/></div>
            <div> 연락처 : <input type="text" class="phoneInput" id="phoneInput"/></div>
            <button type="button" onclick="idFind()"> 찾기 </button>
        </div>
        <div>
            <h3> 비밀번호 찾기 </h3>
            <div> 아이디 : <input type="text" class="midInput" id="midInput"/></div>
            <div> 연락처 : <input type="text" class="mphoneInput" id="mphoneInput"/></div>
            <button type="button" onclick="pwdFind()"> 찾기 </button>
        </div>        
    </div>
</body>
</html>