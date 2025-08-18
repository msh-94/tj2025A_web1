console.log('school.js 확인');

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

// [2] 카카오맵 클러스터 라이브러리
const kmap = async() => {
    // 지도생성
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng( 37.41038125,126.6782658), // 지도의 중심좌표
        level : 7 // 지도의 확대 레벨
    });  
    // 클러스터 생성  
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
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
                        <div id="schoolInfo"> 
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
}// func end
kmap();