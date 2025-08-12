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
        <h3 style="font-size: 30px; padding-top: 10px; padding-bottom: 10px; margin: 0 auto;">홈쇼핑 회원 정보 수정</h3>
        <div style="justify-items: center; justify-content: center; width: 1600px; text-align: center; align-items: center; margin: 0 auto;">            
            <span style="font-weight: bold; font-size: 20px; text-align: center;">회원번호(자동발생)</span> <input type="text" class="numBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">회원성명</span> <input type="text" class="nameBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">회원전화</span> <input type="text" class="phoneBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">회원주소</span> <input type="text" class="adressBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">가입일자</span> <input type="text" class="dateBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">고객등급[A:VIP,B:일반,C:직원]</span> <input type="text" class="gradeBox"/> <br/>
            <span style="font-weight: bold; font-size: 20px; text-align: center;">도시코드</span>  <input type="text" class="cityBox"/> 
        </div>
        <div style="justify-items: center; justify-content: center; width: 1600px; text-align: center; align-items: center; margin: 0 auto;">
            <button type="button" onclick="memberUpdate()" style="background-color: gray; border-radius: 5px; padding: 1px 10px;"> 수 정 </button>
            <button type="button" onclick="againList()" style="background-color: gray; border-radius: 5px; padding: 1px 10px;"> 조 회 </button>
        </div>
    </div>
    <jsp:include page="/assessment/footer.jsp"></jsp:include>
    <script src="update.js"></script>
</body>
</html>