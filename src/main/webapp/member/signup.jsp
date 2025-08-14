<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='/css/member/signup.css'>
    <script src='/js/member/signup.js'></script>    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <h3> 회원가입 페이지 </h3>
        아이디 : <input type="text" class="idInput" id="idInput" onkeyup="idCheck()"/> <br/>
        <div class="idCheck"></div>

        비밀번호 : <input type="password" class="pwdInput" id="pwdInput"/> <br/>

        이름 : <input type="text" class="nameInput" id="nameInput"/> <br/>

        연락처 : <input type="text" class="phoneInput" id="phoneInput" onkeyup="phoneCheck()"/> <br/>
        <div class="phoneCheck"></div>

        <button type="button" onclick="signup()"> 회원가입 </button>
        <a href="/member/login.jsp"> 로그인하기 </a>
        <a href="/member/find.jsp"> 아이디/비밀번호찾기 </a>

    </div>
</body>
</html>