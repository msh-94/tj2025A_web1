<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>   
    <!-- css 가져오기 -->
    <link href="/css/kakao/datamap.css" rel="stylesheet"> 
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <!-- KAKAO 지도가 출력되는 DIV -->
        <div id="map"></div>
        <div id="sidebar"></div>

    </div>
    <!-- KAKAO 지도 API JS : 개발자정의 JS 보다 먼저 호출 권장 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c6c30f9d661acbde0445ec214b19d76&libraries=clusterer"></script>
    <script src="/js/kakao/datamap.js"></script>
</body>
</html>