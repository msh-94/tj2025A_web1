console.log('info.js 확인');

// 내정보조회
const info = async () => {
    try{
        const response = await fetch("/member/info");
        const data = await response.json();
        let html = "";
        if(data.images[0] == null ){
            html = `프로필 사진 : <img src="https://placehold.co/100x100"/>`
        }else{
            html = `프로필 사진 : <img src="/upload/${data.images[0]}"/>`
        }// if end        
        document.querySelector('.mid').innerHTML = data.mid;
        document.querySelector('.mno').innerHTML = data.mno;
        document.querySelector('.mname').innerHTML = data.mname;
        document.querySelector('.mphone').innerHTML = data.mphone;
        document.querySelector('.mdate').innerHTML = data.mdate;
        document.querySelector('.imgBox').innerHTML = html;
    }catch(error){ console.log(error);
        location.href="/member/login.jsp";
    }// catch end
}// func end
info();

// 회원탈퇴
const onDelete = async () => {
    let result = confirm('정말 탈퇴 할까요? ');
    if(result == false){ return; }
    const mpwd = prompt('비밀번호를 입력해주세요 : ');
    try{
        const option = { method : "DELETE" } // option end
        const response = await fetch(`/member/delete?mpwd=${mpwd}`,option);
        const data = await response.json();
        if(data == true){
            alert('회원탈퇴 성공');
            location.href="/index.jsp"
        }else{
            alert('회원탈퇴 실패 : 비밀번호가 일치 하지않습니다.');
        }// if end
    }catch(error){ console.log(error); }// catch end
}// func end

// 포인트 로그 전체조회
const pointLog = async() => {
    const pointtbody = document.querySelector('#pointTbody');
    try{
        const response = await fetch("/point/print"); console.log(response);
        const data = await response.json();     console.log(data);        
        if(data != null){
            let html = "";
            for(let i = 0; i < data.length; i++){
                let log = data[i];  console.log(log);
                html += `<tr>
                            <td>${log.plno}</td>
                            <td>${log.plpoint}</td>
                            <td>${log.plcomment}</td>
                            <td>${log.pldate}</td>                        
                        </tr>`
            }// for end     
            console.log(html);
            pointtbody.innerHTML = html;       
        }// if end        
    }catch(error){ console.log(error); }
}// func end
pointLog();