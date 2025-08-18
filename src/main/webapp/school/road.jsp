<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>   
    <style>
        #container {overflow:hidden;height:300px;position:relative;}
        #btnRoadview,  #btnMap {position:absolute;top:5px;left:5px;padding:7px 12px;font-size:14px;border: 1px solid #dbdbdb;background-color: #fff;border-radius: 2px;box-shadow: 0 1px 1px rgba(0,0,0,.04);z-index:1;cursor:pointer;}
        #btnRoadview:hover,  #btnMap:hover{background-color: #fcfcfc;border: 1px solid #c1c1c1;}
        #container.view_map #mapWrapper {z-index: 10;}
        #container.view_map #btnMap {display: none;}
        #container.view_roadview #mapWrapper {z-index: 0;}
        #container.view_roadview #btnRoadview {display: none;}
        .custom-info-window {
            background: white;
            border: 2px solid #333;
            border-radius: 8px;
            padding: 10px;
            font-size: 13px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.3);
            max-width: 250px;
        }
    </style>     
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="wrap">
        <div id="container" class="view_map" >
            <div id="mapWrapper" style="width:100%;height:300px; position:relative;">
                <div id="map" style="width:100%;height:100%"></div> <!-- 지도를 표시할 div 입니다 -->
                <input type="button" id="btnRoadview" onclick="toggleMap(false)" title="로드뷰 보기" value="로드뷰">
            </div>
            <div id="rvWrapper" style="width:100%;height:300px;position:absolute;top:0;left:0;">
                <div id="roadview" style=" width: 100%; height:100%"></div> <!-- 로드뷰를 표시할 div 입니다 -->
                <input type="button" id="btnMap" onclick="toggleMap(true)" title="지도 보기" value="지도">
            </div>
        </div>
        <div id="sidebar" style="width: 100%; padding: 10px; overflow-y: auto;"></div>
    </div>
    
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c6c30f9d661acbde0445ec214b19d76&libraries=clusterer"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c6c30f9d661acbde0445ec214b19d76"></script>    
    <script src="/js/school/road.js"></script>
</body>
</html>