<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- css 가져오기 -->
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>
    <div id="header">
        <ul id="sub-menu">
            <li> <a href="/index.jsp"><img src="/img/123.jpg"></a></li>
            <li> <a href="/datago/data.jsp"> 공공데이터 </a> </li>
            <li> <a href="/kakao/map.jsp"> 카카오지도 </a> </li>
            <li> <a href="#"> 메뉴3 </a> </li>
        </ul>
        <ul id="log-menu">
            <!-- 로그인 안했을때 구역 / 로그인 했을때 구역 js해서 표현-->            
        </ul>
    </div>
    <!-- js 가져오기 -->
     <script src="/js/header.js"></script>

</body>
</html>