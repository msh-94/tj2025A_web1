<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>   
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <h3> 회원정보 수정 페이지 </h3>
        <form id="updateForm">
            <div> 프로필사진 : <input type="file" name="uploads"/></div>
            <div> 회원번호 : <span class="mno" name="mno"> </span></div>
            <div> 아이디 : <span class="mid" name="mid"> </span></div>       
            <div> 이름 : <input class="mname" name="mname"/> </div>
            <div> 연락처 : <input class="mphone" name="mphone"/> </div>                   
            <button type="button" onclick="onUpdate()"> 수정 </button>
        </form>
    </div>

    <script src='/js/member/update.js'></script> 
</body>
</html>