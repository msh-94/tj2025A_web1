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
    <jsp:include page="/assessment/header.jsp"></jsp:include>
    <div style="background-color: gray; width: 1900px; height: 500px; text-align: center; ">
        <h3 style="font-size: 30px; padding-top: 10px; padding-bottom: 10px; margin: 0 auto;">회원매출조회</h3>
        <table border="1" style="justify-items: center; justify-content: center; width: 1600px; text-align: center; align-items: center; margin: 0 auto;">
            <thead>
                <tr>
                    <th>회원번호</th> <th>회원성명</th> <th>고객등급</th> <th>매출</th>
                </tr>
            </thead>
            <tbody id="salesTbody">                
            </tbody>
        </table>
    </div>
    <jsp:include page="/assessment/footer.jsp"></jsp:include>
    <script src="sales.js"></script>
</body>
</html>