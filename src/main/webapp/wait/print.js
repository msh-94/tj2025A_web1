console.log("print.js 확인")

// 전체조회 기능
const print = async () => {
    const waitbody = document.querySelector("#waitBody");
    let html = "";
    const option = { method : "GET"}
    const response = await fetch("/wait/print",option);
    const data = await response.json();
    for(let i = 0; i < data.length; i++){
        let wait = data[i];
        html += `<tr>
                    <td>${wait.wno}</td>
                    <td>${wait.phone}</td>
                    <td>${wait.count}</td>
                    <td>${wait.wdate}</td>
                </tr>`
    }// for end
    waitbody.innerHTML = html;
}// func end
print();