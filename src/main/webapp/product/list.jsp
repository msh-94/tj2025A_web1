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
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div id="map" style="width:100%;height:350px;"></div>
        <div id="product">

        </div>
    </div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c6c30f9d661acbde0445ec214b19d76&libraries=clusterer"></script>
    <script src="/js/kakao/position.js"></script>
    <script src='/js/product/list.js'></script>
</body>
</html>