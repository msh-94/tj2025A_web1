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
        <h3> 대기 등록 페이지 </h3>
        전화번호 : <input type="tel" class="phoneBox"/> <br/>
        인원수 : <input type="number" class="countBox"/> <br/>
        <button type="button" onclick="waitAdd()"> 등록 </button>
    </div>
    <script src="write.js"></script>
</body>
</html>