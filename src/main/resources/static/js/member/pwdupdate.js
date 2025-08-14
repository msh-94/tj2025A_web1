console.log('pwdupdate.js 확인');

// 비밀번호 수정
const onPwdUpdate = async () => {
    const oldPwd = document.querySelector('#oldpwd').value;
    const newPwd = document.querySelector('#newpwd').value;
    const obj = { oldPwd , newPwd }
    try{
        const option = {
            method : "PUT" ,
            headers : { "Content-Type" : "application/json" } ,
            body : JSON.stringify(obj)
        }// option end
        const response = await fetch("/member/update/password",option);
        const data = await response.json();
        if(data == true){
            alert('비밀번호가 변경되었습니다.');
            location.href="/member/info.jsp";
        }else{
            alert('비밀번호 수정 실패');
        }// if end
    }catch(error){ console.log(error); }// catch end
}// func end