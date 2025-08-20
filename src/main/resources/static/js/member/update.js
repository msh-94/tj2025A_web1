console.log('update.js 확인');

 // 회원정보 수정
const onUpdate = async () => {      
    const updateForm = document.querySelector('#updateForm');
    const updateFormData = new FormData(updateForm);
    const mno = document.querySelector('.mno').innerHTML;
    const mid = document.querySelector('.mid').innerHTML;    
    updateFormData.append('mno', mno);
    updateFormData.append('mid', mid);
    try{
        const option = {
            method : "PUT" ,             
            body : updateFormData
        }// option end
        const response = await fetch("/member/update",option);  console.log(response);
        const data = await response.json();     console.log(data);
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
