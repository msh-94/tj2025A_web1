<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='/css/member/info.css'>
       
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div>
            <h3> 마이 페이지 </h3>
            <div>회원번호 : <span class="mno"></span></div> 
            <div>아이디 : <span class="mid"></span></div> 
            <div>이름 : <span class="mname"></span></div> 
            <div>연락처 : <span class="mphone"></span></div> 
            <div>가입일 : <span class="mdate"></span></div> 
            <a href="/member/update.jsp"> 회원정보 수정 </a>
            <a href="/member/pwdupdate.jsp"> 비밀번호 수정 </a>
            <a href="#" onclick="onDelete()"> 회원 탈퇴 </a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>로그번호</th> <th>포인트</th> <th>사유</th> <th>로그등록일</th>
                </tr>
            </thead>
            <tbody id="pointTbody">
            </tbody>
        </table>
    </div>
    <script src='/js/member/info.js'></script> 
</body>
</html>