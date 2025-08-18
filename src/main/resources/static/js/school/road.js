console.log('road.js 확인');

// [1] 공공데이터
const schoolAPI = async() => {
    const serviceKey = "yEuDg6mhI4rl%2BfM8AjkjZP7rc8bakzSDaSk%2BtC8YCBM9wNnl8E1h5rXlflFfMXMLjJQZNrZvLQNGT97JfZAKGA%3D%3D";
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=";
    const response = await fetch(URL+serviceKey);
    const data = await response.json();
    const sidebar = document.querySelector("#sidebar");
    let html = "";
    data.data.forEach( (value) => {
        html += `<div id="schoolInfo">
                    <div>${value.학교명}</div>
                    <div>${value.행정실}</div>
                    <div>${value.주소}</div>
                </div>`
     })
    sidebar.innerHTML = html;
} // func end
schoolAPI();

// [2] 로드뷰와 지도 토글하기
const togle = async() => {    
    rvContainer = document.getElementById('roadview'), // 로드뷰를 표시할 div 입니다
    mapContainer = document.getElementById('map'); // 지도를 표시할 div 입니다
    // 지도와 로드뷰 위에 마커로 표시할 특정 장소의 좌표입니다 
    var placePosition = new kakao.maps.LatLng( 37.41038125, 126.6782658 ); // 연수구청 좌표
    // 지도 옵션입니다 
    var mapOption = {
        center: placePosition, // 지도의 중심좌표 
        level: 4 // 지도의 확대 레벨
    };
    // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);
    // 로드뷰 객체를 생성합니다 
    var roadview = new kakao.maps.Roadview(rvContainer);
    // 클러스터 생성  
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
    // 마커 생성 및 반환
    const serviceKey = "yEuDg6mhI4rl%2BfM8AjkjZP7rc8bakzSDaSk%2BtC8YCBM9wNnl8E1h5rXlflFfMXMLjJQZNrZvLQNGT97JfZAKGA%3D%3D";
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=";
    const response = await fetch(URL+serviceKey);
    const data = await response.json();  
    let markers = data.data.map( (position) => {
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng(position.위도, position.경도)
        });
        kakao.maps.event.addListener( marker , 'click' , () => {
            const sidebar = document.querySelector('#sidebar');
            let html = `<button type="button" onclick="schoolAPI()"> 전체보기 </button>
                        <div id="schoolInfo" style="margin-bottom:20px;"> 
                            <div>학교명 : ${position.학교명}</div>
                            <div>행정실 : ${position.행정실}</div>
                            <div>주소 : ${position.주소}</div>
                        </div>`
            sidebar.innerHTML = html;
        })
        return marker;
    })// map end 
    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;
        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
    var roadviewClient = new kakao.maps.RoadviewClient();
    roadviewClient.getNearestPanoId(placePosition, 50, function(panoId) {
        roadview.setPanoId(panoId, placePosition);
        // 시점 설정 (옵션)
        roadview.setViewpoint({
            pan: 321,
            tilt: 0,
            zoom: 0
        });
        //  InfoWindow 생성
        let infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

        // 로드뷰 마커 추가
        let rvMarkers = data.data.map( (position) => {
            let rvmarker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.위도 , position.경도),
                map : roadview , 
                zIndex : 10
            });            
            kakao.maps.event.addListener(rvmarker, 'click', () => {
            infowindow.setContent(`<div class="custom-info-window">학교명: ${position.학교명}</div>`);
            infowindow.open(roadview, rvmarker);
            const sidebar = document.querySelector('#sidebar');
            sidebar.innerHTML = `
                <button type="button" onclick="schoolAPI()">전체보기</button>
                <div id="schoolInfo" style="margin-top:10px;">
                    <div>학교명 : ${position.학교명}</div>
                    <div>행정실 : ${position.행정실}</div>
                    <div>주소 : ${position.주소}</div>
                </div>`;
            });
            return rvmarker;
        });// map end               
    });// panoId end
}// func end
togle();

// 지도와 로드뷰를 감싸고 있는 div의 class를 변경하여 지도를 숨기거나 보이게 하는 함수입니다 
function toggleMap(active) {
    if (active) {

        // 지도가 보이도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
        container.className = "view_map"
    } else {

        // 지도가 숨겨지도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
        container.className = "view_roadview"   
    }
}// func end