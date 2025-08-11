console.log("print.js 확인");

// 전체조회 기능
const print = async () => {
    const boardbody = document.querySelector('#boardBody');
    let html = "";
    const option = { method : "GET" }
    const response = await fetch("/board",option)
    const data = await response.json();
    for(let i = 0; i < data.length; i++){
        let board = data[i];
        html += `<tr>
                    <td>${board.bno}</td>
                    <td><a href="/board/view.jsp?bno=${board.bno}">${board.bcontent}</a></td>
                    <td>${board.bwriter}</td>                    
                </tr>`
    }// for end
    boardbody.innerHTML = html;
}// func end
print();

