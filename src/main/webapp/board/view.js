console.log("view.js 확인");

// 개별 조회
const find = async () => {
    const bwriter = document.querySelector(".bwriterBox");
    const bcontent = document.querySelector(".bcontentBox");        
    const bno = new URLSearchParams(location.search).get('bno');    
    const response = await fetch(`/board/find?bno=${bno}`);
    const data = await response.json();     
    html1 = data.bwriter
    html2 = data.bcontent 
    bwriter.innerHTML = html1;
    bcontent.innerHTML = html2;
}// func end
find();

// 삭제 기능
const dlt = async () => {
    const bno = new URLSearchParams(location.search).get('bno');   
    let check = confirm('정말 삭제 할까요?');
    if(check == true){
        const option = { method : "DELETE" }
        const response = await fetch(`/board?bno=${bno}`,option);
        const data = await response.json(); console.log(data);
        if(data == true){
            alert("삭제가 완료되었습니다.");
            location.href = "/board/print.jsp";
        }else{
            alert('삭제 실패')
        }// if end
    }// if end    
}// func end

// 수정페이지로 이동
const boardUpdateView = async () => {
    const bno = new URLSearchParams(location.search).get('bno');   
    let check = confirm('수정 하시겠습니까?');
    if(check == true){
        location.href=`/board/update.jsp?bno=${bno}`; // view.jsp 와 update.jsp 는 bno를 쿼리스트링 매개변수 사용
    }// if end    
}// func end