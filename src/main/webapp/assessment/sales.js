console.log("sales.js 확인");

// 회원매출조회
const salesPrint = async () => {
    const salesbody = document.querySelector('#salesTbody');
    let html = "";
    const response = await fetch("/money");
    const data = await response.json();
    for(let i = 0; i < data.length; i++){
        let sale = data[i];
        html += `<tr>
                    <td>${sale.회원번호}</td>
                    <td>${sale.회원성명}</td>
                    <td>${sale.고객등급}</td>
                    <td>${sale.매출}</td>
                </tr>`
    }// for end
    salesbody.innerHTML = html;
}// func end
salesPrint();