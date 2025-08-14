console.log('login.js 확인');

// 로그인 기능
const login = async () => {
    // document(HTML뜻) , query(질의)selector(선택자)
    const mid = document.querySelector('#idInput').value;    
    const mpwd = document.querySelector('#pwdInput').value; 
    if(mid == ''){ alert('아이디를 입력해주세요'); return;};
    if(mpwd == ''){alert('비밀번호를 입력해주세요'); return;};   
    const obj = { mid , mpwd };    
    try{
        const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json"} ,
        body : JSON.stringify(obj)
        }// option end
        const response = await fetch("/member/login",option);
        const data = await response.json();        
        if(data > 0){
            alert('로그인 성공');
            location.href = "/index.jsp";
        }else{
            alert('로그인 실패:계정 정보가 일치하지 않습니다.');
        }// if end
    }catch{
        alert('오류발생 관리자에게 문의하세요');
    }// catch end
}// func end