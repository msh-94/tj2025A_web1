console.log('find.js 확인');

// 아이디 찾기
const idFind = async () => {
    const mname = document.querySelector('#mnameInput').value;
    const phoneinput = document.querySelector('#phoneInput').value;
    try{
        const response = await fetch(`/member/idfind?mname=${mname}&mphone=${phoneinput}`);
        const data = await response.json();
        alert(`아이디 : ${data.mid}`);
        location.href="/member/login.jsp";
    }catch{
        alert('회원정보 불일치');
    }// catch end
}// func end

// 비밀번호 찾기
const pwdFind = async () => {
    const mid = document.querySelector('#midInput').value;
    const mphone = document.querySelector('#mphoneInput').value;
    try{
        const response = await fetch(`/member/pwdfind?mid=${mid}&mphone=${mphone}`);
        const data = await response.json();
        if(data.msg != null){
            alert(`임시비밀번호 : ${data.msg}`);
            location.href="/member/login.jsp";
        }else{
            alert('회원정보 불일치');
        }// if end
    }catch(error){ console.log(error);
        alert('회원정보 불일치');
    }// catch end
}// func end