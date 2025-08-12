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
    <div>
        <h3> 홈쇼핑 회원 등록 </h3>
        <div>            
            회원번호(자동발생) : <input type="text" class="numBox"/> <br/>
            회원성명 : <input type="text" class="nameBox"/> <br/>
            회원전화 : <input type="text" class="phoneBox"/> <br/>
            회원주소 : <input type="text" class="adressBox"/> <br/>
            가입일자 : <input type="text" class="dateBox"/> <br/>
            고객등급[A:VIP,B:일반,C:직원] : <input type="text" class="gradeBox"/> <br/>
            도시코드 : <input type="text" class="cityBox"/> 
        </div>
        <div>
            <button type="button" onclick="memberAdd()"> 등록 </button>
            <button type="button" onclick="listView()"> 조회 </button>
        </div>
    </div>
    <jsp:include page="/assessment/footer.jsp"></jsp:include>
    <script src="write.js"></script>
</body>
</html>