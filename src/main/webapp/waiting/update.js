console.log("update.js 확인");

// 개별조회
const refind = async () => {
    const tellbox = document.querySelector('.tellBox');
    const numbox = document.querySelector('.numBox');
    const wno = new URLSearchParams(location.search).get('wno');
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    tellbox.value = data.phone;
    numbox.value = data.count;
}// func end
refind();

// 수정기능
const waitUpdate = async () => {
    const wno = new URLSearchParams(location.search).get('wno');
    const tell = document.querySelector('.tellBox').value;
    const num = document.querySelector('.numBox').value;
    const obj = { wno : `${wno}` , phone : tell , count : num };
    const option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(obj)
    }// option end
    const response = await fetch("/waiting",option);
    const data = await response.json();
    if(data == true){
        alert('수정 성공')
        location.href = `/waiting/view.jsp?wno=${wno}`
    }else{
        alert('수정 실패')
    }// if end
}// func end