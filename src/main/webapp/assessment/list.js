console.log("list.js 확인");

// 회원목록 조회
const memberPrint = async () => {
    const listbody = document.querySelector('#listTbody');
    let html = "";
    const response = await fetch("/member");
    const data = await response.json();
    for(let i = 0; i < data.length; i++){
        let list = data[i];
        html += `<tr>
                    <td><a href="/assessment/update.jsp?custno=${list.custno}">${list.custno}</a></td> <td>${list.custname}</td> <td>${list.phone}</td>
                    <td>${list.address}</td> <td>${list.joindate}</td> <td>${list.grade}</td> <td>${list.city}</td>
                </tr>`
    }// for end
    listbody.innerHTML = html;
}// func end
memberPrint();