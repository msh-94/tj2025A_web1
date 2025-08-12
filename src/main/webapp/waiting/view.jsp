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
    <jsp:include page="/waiting/header.jsp"></jsp:include>

    <div>
        <h3> 대기 현황 상세 페이지 </h3>
        대기번호 : <div class="wnoBox"></div>
        전화번호 : <div class="phone1Box"></div>
        인원수 : <div class="count1Box"></div>
        등록날짜 : <div class="addDateBox"></div>
        <button type="button" onclick="dlt()"> 삭제 </button>
        <button type="button" onclick="waitUpdateView()"> 수정 </button>
    </div>
    <script src="view.js"></script>
</body>
</html>