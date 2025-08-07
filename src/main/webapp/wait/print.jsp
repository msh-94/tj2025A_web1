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
    <jsp:include page="/wait/header.jsp"></jsp:include>
    <div>
        <h3> 대기 조회 페이지 </h3>
        <table border="1">
            <thead>
                <tr>
                    <th> 대기번호 </th> <th> 전화번호 </th> <th> 인원수 </th> <th> 등록일 </th>
                </tr>
            </thead>
            <tbody id="waitBody">

            </tbody>
        </table>
    </div>

    <script src="print.js"></script>
</body>
</html>