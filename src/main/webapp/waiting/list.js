console.log("list.js 확인");

// 전체조회 기능
const waitingPrint = async () => {
    const waitbody = document.querySelector('#waitingTbody')
    let html = "";
    const response = await fetch("/waiting");
    const data = await response.json();
    for(let i = 0; i < data.length; i++){
        let waiting = data[i];
        html += `<tr>
                    <td><a href="/waiting/view.jsp?wno=${waiting.wno}">${waiting.wno}</a></td>
                    <td><a href="/waiting/view.jsp?wno=${waiting.wno}">${waiting.phone}</a></td>
                    <td><a href="/waiting/view.jsp?wno=${waiting.wno}">${waiting.count}</a></td>
                    <td><a href="/waiting/view.jsp?wno=${waiting.wno}">${waiting.addDate}</a></td>
                </tr>`
    }// for end
    waitbody.innerHTML = html;
}// func end
waitingPrint();