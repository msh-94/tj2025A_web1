<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <!-- 현재 JSP 파일내 다른 JSP 포함하기 -->
    <jsp:include page="/student/header.jsp"></jsp:include>
    <div>
        <h3> 메인 페이지 <h3>
        <p> localhost:8080/student/index.jsp </p>
    </div>   

    <script src="student.js"></script>
</body>
</html>