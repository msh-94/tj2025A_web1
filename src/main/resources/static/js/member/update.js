console.log('update.js 확인');

 // 회원정보 수정
const onUpdate = async () => {      
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;    
    if(mname == ''){alert('이름을 입력해주세요'); return; }
    if(mphone == ''){alert('연락처를 입력해주세요'); return; }
    const obj = { mname , mphone }
    try{
        const option = {
            method : "PUT" , 
            headers : { "Content-Type" : "application/json" } ,
            body : JSON.stringify(obj)
        }// option end
        const response = await fetch("/member/update",option);
        const data = await response.json();
        if(data == true){
            alert('회원정보가 수정되었습니다.');
            location.href="/member/info.jsp";
        }else{
            alert('회원정보 수정 실패')
        }// if end
    }catch(error){ console.log(error); }
}// func end

// 회원번호 아이디 출력
const mUpdate = async () => {
    try{
        const response = await fetch("/member/info");
        const data = await response.json();
        document.querySelector('.mno').innerHTML = data.mno;
        document.querySelector('.mid').innerHTML = data.mid;
    }catch(error){ console.log(error); 
        location.href="/member/login.jsp";
    } //catch end
}// func end
mUpdate();
