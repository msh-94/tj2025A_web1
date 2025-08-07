console.log("add.js 확인")

// 등록기능
const add = async () => {
    const phoneInput = document.querySelector(".phone");
    const countInput = document.querySelector(".count");
    const phone = phoneInput.value;
    const count = countInput.value;
    const obj = { phone , count }
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(obj)
    }// option end
    const response = await fetch("/wait/add",option);
    const data = await response.json();
    if(data == true){
        alert(`등록 성공`)
        location.href="/wait/print.jsp"
    }else{
        alert(`등록 실패`)
    }// if end
}// func end