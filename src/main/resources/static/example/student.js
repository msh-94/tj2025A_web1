console.log("JS 확인")

// 1. 등록 기능
const func1 = () => {
    let data = { "sname" : "테스트용" , "skor" : 50 , "smath" : 60 }
    let option = {
        method : "POST" ,
        headers : "Content-Type" : "application/json" ,
        body : JSON.stringify(data)
    }// option end
    fetch("/student/save",option)
        .then( response => response.json() )
        .then( d => { console.log(d) } )
        .catch( error => { console.log(error) } )
}// func end

// 2. 전체조회 기능
const func2 = () => {
    let option = { method : "GET" }
    fetch("/student/find",option)
        .then( response => response.json() )
        .then( data => { console.log(data) } )
        .catch( error => { console.log(error) } )
}// func end