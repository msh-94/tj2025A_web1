console.log("view.js 확인");

// 특정 대기현황 조회
const waitFind = async () => {
    const wnobox = document.querySelector('.wnoBox');
    const phonebox = document.querySelector('.phone1Box');
    const countbox = document.querySelector('.count1Box');
    const addDatebox = document.querySelector('.addDateBox');
    const wno = new URLSearchParams(location.search).get('wno');
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    wnobox.innerHTML = data.wno;
    phonebox.innerHTML = data.phone;
    countbox.innerHTML = data.count;
    addDatebox.innerHTML = data.addDate;    
}// func end
waitFind();

// 삭제 기능
const dlt = async () => {
    const wno = new URLSearchParams(location.search).get('wno');
    let check = confirm('정말 삭제 하시겠습니까?');
    if(check == true){
        const option = { method : "DELETE" }
        const response = await fetch(`/waiting?wno=${wno}`,option);
        const data = await response.json();
        if(data == true){
            alert('삭제 성공')
            location.href = "/waiting/list.jsp"
        }else{
            alert('삭제 실패')
        }// if end
    }// if end
}// func end

// 수정페이지 이동
const waitUpdateView = async () => {
    const wno = new URLSearchParams(location.search).get('wno');
    let check = confirm('수정 하시겠습니까?');
    if(check == true){
        location.href=`/waiting/update.jsp?wno=${wno}`;
    }// if end
}// func end
