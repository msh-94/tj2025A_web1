console.log('signup.js 확인');

// *** 유효성 검사 체크리스트 ***
const signPass = [ false , false ]; // 초기값은 실패 , 0인덱스 : 아이디체크 , 1인덱스 : 연락처 체크

// 회원가입
const signup = async () => {
    // js 배열내 요소찾기 .indexOf()  , .includes() : 배열내 요소가 존재하는지 true/false 반환
    if(signPass.includes(false)){ alert('올바른 정보를 입력해주세요'); return;}    
    const mid = document.querySelector('#idInput').value;
    const mpwd = document.querySelector('#pwdInput').value;
    const mname = document.querySelector('#nameInput').value;
    const mphone = document.querySelector('#phoneInput').value;
    if(mid == ''){alert('아이디를 입력해주세요'); return;}
    if(mpwd == ''){alert('비밀번호를 입력해주세요'); return;}
    if(mname == ''){alert('이름을 입력해주세요'); return;}
    if(mphone == ''){alert('연락처를 입력해주세요'); return;}    
    const obj = { mid , mpwd , mname , mphone };
    try{
        const option = {
            method : "POST" ,
            headers : { "Content-Type" : "application/json" } ,
            body : JSON.stringify(obj)
        }// option end
        const response = await fetch("/member/signup",option);
        const data = await response.json();
        if(data > 0){
            alert('회원가입 성공');
            location.href="/member/login.jsp";
        }else{alert('회원가입 실패')} // if end
    }catch(error){console.log(error); }// catch end
}// func end

// 아이디 중복검사
const idCheck = async () => {
    const mid = document.querySelector('#idInput').value;
    // 유효성검사 길이검사
    if(mid.length < 4){ // 만약에 아이디가 4글자 미만이면
        document.querySelector('.idCheck').innerHTML = `아이디는 4글자 이상으로 가능합니다.`;
        signPass[0] = false;
        return;
    }// if end
    const idCheck = document.querySelector('.idCheck');
    try{
        const response = await fetch(`/member/check?type=mid&data=${mid}`);
        const data = await response.json();
        if(data == true){ idCheck.innerHTML = "이미 존재하는 아이디입니다."; signPass[0] = false; }
        else{ idCheck.innerHTML = '사용가능한 아이디입니다.'; signPass[0] = true; }// if end
    }catch{ }// catch end
}// func end


// 연락처 중복검사
const phoneCheck = async () => {
    const mphone = document.querySelector('#phoneInput').value;
    const phoneCheck = document.querySelector('.phoneCheck');
    if(mphone.length != 13){
        phoneCheck.innerHTML = '연락처는 -(하이픈)포함 13자리로 입력해주세요';
        signup[1] = false;
        return;
    }// if end
    try{
        const response = await fetch(`/member/check?type=mphone&data=${mphone}`);
        const data = await response.json();
        if(data == true){
            phoneCheck.innerHTML = "이미 존재하는 연락처입니다."; 
            signPass[1] = false;           
        }else{
            phoneCheck.innerHTML = '사용가능한 연락처입니다.';  
            signPass[1] = true;           
        }// if end
    }catch(error){ console.log(error); }// catch end
}// func end
