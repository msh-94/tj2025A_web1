// * JS 실행 확인
console.log("header.js 확인");

// [1] 내정보 요청해서 메뉴 나누기
const myinfo = async () => {
    const logMenu = document.querySelector("#log-menu"); // 어디에
    let html = ""; // 무엇을
    try{
        // 1. fetch 실행
        const response = await fetch("/member/info");
        const data = await response.json();  console.log(data);
        // 2. [로그인중]로그인 했을때 정상 fetch
        html += `<li> <span> ${data.mid}님 100 POINT </span></li>
            <li> <a href="/member/info.jsp"> 내정보 </a></li>
            <li> <a href="#" onclick="logout()"> 로그아웃 </a></li>`
        
    }catch{        
        html += `<li> <a href="/member/login.jsp"> 로그인 </a></li>
            <li> <a href="/member/signup.jsp"> 회원가입 </a></li>`
    }// catch end    
    logMenu.innerHTML = html;
}// func end
myinfo();

// [2] 로그아웃
const logout = async () => {    
    try{
        const response = await fetch("/member/logout");
        const data = await response.json();         console.log(data);
        if(data == true){
            alert('로그아웃 성공');
            location.href = "/index.jsp"; // 메인페이지로 이동
        }else{
            alert('비정상 요청 및 관리자에게 문의')
        }// if end        
    }catch{ }// catch end    
}// func end