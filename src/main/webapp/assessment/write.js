console.log("write.js 확인");

// 회원등록기능
const memberAdd = async () => {
    const custno = document.querySelector('.numBox').value;
    const custname = document.querySelector('.nameBox').value;
    if(custname == ''){alert('회원성명이 입렵되지않았습니다'); return;}
    const phone = document.querySelector('.phoneBox').value;
    if(phone == ''){alert('회원전화가 입렵되지않았습니다'); return;}
    const address = document.querySelector('.adressBox').value;
    if(address == ''){alert('주소가 입렵되지않았습니다'); return;}
    const joindate = document.querySelector('.dateBox').value;
    const grade = document.querySelector('.gradeBox').value;
    if(grade == ''){alert('고객등급이 입렵되지않았습니다'); return;}
    const city = document.querySelector('.cityBox').value;
    if(city == ''){alert('도시코드가 입렵되지않았습니다'); return;}
    const obj = { custno , custname , phone , address , joindate , grade , city };
    const option = {
        method : "POST" , 
        headers : {"Content-Type" : "application/json"} , 
        body : JSON.stringify(obj)
    }// option end
    const response = await fetch("/member",option);
    const data = await response.json();
    if(data == true){
        alert('회원등록이 완료되었습니다')
        location.href = "/assessment/list.jsp"
    }else{
        alert('회원등록 실패')
    }// if end
}// func end

// 조회페이지로 이동 기능
const listView = async () => {
    location.href = "/assessment/list.jsp"
}// func end

// 회원번호 현재날짜 출력
const returnMember = async () => {
    const num = document.querySelector('.numBox');
    const nowDate = document.querySelector('.dateBox');
    const response = await fetch("/member/num");
    const data = await response.json();
    num.value = data.custno+1;
    nowDate.value = data.joindate;
}//func end
returnMember();