console.log("update.js 확인");

// 개별조회기능
const memberFind = async () => {
    const custno = new URLSearchParams(location.search).get('custno');
    const num = document.querySelector('.numBox');
    const name = document.querySelector('.nameBox');
    const phonebox = document.querySelector('.phoneBox');
    const adress = document.querySelector('.adressBox');
    const datebox = document.querySelector('.dateBox');
    const gradebox = document.querySelector('.gradeBox');
    const citybox = document.querySelector('.cityBox');
    const response = await fetch(`/member/find?custno=${custno}`);
    const data = await response.json();
    if(data.grade == "VIP"){
        data.grade = "A"
    }else if(data.grade == "일반"){
        data.grade = "B"
    }else if(data.grade == "직원"){
        data.grade = "C"
    }// if end
    num.value = data.custno;
    name.value = data.custname;
    phonebox.value = data.phone;
    adress.value = data.address;
    datebox.value = data.joindate;
    gradebox.value = data.grade;
    citybox.value = data.city;
}// func end
memberFind();

// 수정기능
const memberUpdate = async () => {
    const custno = document.querySelector('.numBox').value;
    const custname = document.querySelector('.nameBox').value;
    const phone = document.querySelector('.phoneBox').value;
    const address = document.querySelector('.adressBox').value;
    const joindate = document.querySelector('.dateBox').value;
    const grade = document.querySelector('.gradeBox').value;
    const city = document.querySelector('.cityBox').value;
    const obj = { custno , custname , phone , address , joindate , grade , city };
    const option = {
        method : "PUT" , 
        headers : { "Content-Type" : "application/json"} ,
        body : JSON.stringify(obj)
    }// option end
    const response = await fetch("/member",option);
    const data = await response.json();
    if(data == true){
        alert('회원정보수정이 완료 되었습니다.')
        location.href = "/assessment/list.jsp"
    }else{
        alert('회원정보 수정이 실패하였습니다.')
    }// if end
}// func end

// 조회페이지로 이동
const againList = async () => {
    location.href = "/assessment/list.jsp"
}// func end