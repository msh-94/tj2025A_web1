console.log("update.js 확인");

// 개별조회 (수정하기전 내용물 확인용)
const refind = async () => {
    const bcontent = document.querySelector("#updateContent");        
    const bno = new URLSearchParams(location.search).get('bno');    
    const response = await fetch(`/board/find?bno=${bno}`);
    const data = await response.json();
    html2 = data.bcontent 
    bcontent.innerHTML = html2;
}// func end
refind();
// 수정 기능
const update = async () => {
    const bno = new URLSearchParams(location.search).get('bno');  
    const contentBox = document.querySelector('#updateContent');
    const content = contentBox.value;
    const obj = { bno : `${bno}` , bcontent : content }; console.log(obj);
    const option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(obj)
    }// option end    
    const response = await fetch("/board",option);   console.log(option); console.log(response)
    const data = await response.json();   console.log(data);
    if(data == true){
        alert('수정 성공')
        location.href = `/board/view.jsp?bno=${bno}`
    }else{
        alert('수정 실패')
    }// if end
}// func end