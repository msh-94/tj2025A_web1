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
    <jsp:include page="/board/header.jsp"></jsp:include>
    <div>
        <h3> 게시판 조회 페이지 </h3>
        <table border="1">
            <thead>
                <tr>
                    <th> 게시물번호 </th> <th> 내용 </th> <th> 작성자 </th>
                </tr>
            </thead>
            <tbody id="boardBody">                
            </tbody>
        </table>
    </div>

    <script src="print.js"></script>
</body>
</html>