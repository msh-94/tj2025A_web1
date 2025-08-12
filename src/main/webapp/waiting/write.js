console.log("write.js 확인")

// 대기 등록
const waitAdd = async () => {
    const phone = document.querySelector(".phoneBox").value;
    const count = document.querySelector(".countBox").value;
    const obj = { phone , count };
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(obj)
    }// option end
    const response = await fetch("/waiting",option);
    const data = await response.json();
    if(data == true){
        alert('등록 성공')
        location.href = "/waiting/list.jsp"
    }else{
        alert('등록 실패')
    }// if end
}// func end