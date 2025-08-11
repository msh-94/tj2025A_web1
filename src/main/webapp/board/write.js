console.log("write.js 확인");

// 등록기능
const writer = async () => { console.log("write()")
    const contentInput = document.querySelector(".content");    console.log(contentInput);
    const writerInput = document.querySelector(".writer");      console.log(writerInput);
    const content = contentInput.value;
    const writer = writerInput.value;
    const obj = { bcontent : content , bwriter : writer };       console.log(obj);
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(obj)
    }// option end  
    const response = await fetch("/board",option);       console.log(fetch);    console.log(option);
    const data = await response.json();                 console.log(data);
    if(data == true){
        alert('등록 성공')
        location.href="/board/print.jsp"
    }else{
        alert('등록 실패')
    }// if end
}// func end