// 연동확인
console.log("JS연동 확인");

// 대기 등록
const waitAdd = ( ) => {
    console.log("대기등록 확인")
    let data = { "phone" : "010-1234-1234" , "count" : 12 }
    let option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(data)
    }// option end
    fetch("/wait",option)
        .then( response => response.json() )
        .then( d => { console.log(d); } )
        .catch( error => { console.log(error); } )// fetch end
}// func end

// 전체조회
const waitPrint = () => {
    console.log("전체조회 확인")
    let option = { method : "GET" } // option end
    fetch("/wait" , option)
        .then( response => response.json() )
        .then( data => { console.log(data); } )
        .catch( error => { console.log(error); } )// fetch end
}// func end

// 대기 삭제
const waitDelete = () => {
    console.log("대기 삭제 확인")
    let wno = 4;
    let option = { method : "DELETE" } // option end
    fetch(`/wait?wno=${wno}`,option)
        .then( response => response.json() )
        .then( data => { console.log(data); } )
        .catch( error => { console.log(error); } )// fetch end
}// func end

// 대기 수정
const waitUpdate = () => {
    console.log("대기 수정 확인")
    let data = { "wno" : 2 , "count" : 11 }
    let option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(data)
    }// option end
    fetch("/wait" , option)
        .then( response => response.json() )
        .then( d => { console.log(d); } )
        .catch( error => { console.log(error); } ) // fetch end
}// func end