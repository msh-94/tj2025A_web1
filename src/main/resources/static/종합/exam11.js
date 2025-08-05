// 1. 연동 확인
console.log("1.exam11.js");

// 2. 함수 연동 확인
// 일반 함수 선언 : function 함수명(){}
// 람다식 함수 선언 : const 함수명 = () => {}
const boardWrite = () => {
    console.log("boardWrite() exe")
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = { "bcontent" : "JS테스트" , "bwriter" : "유재석" }
    // (2) fetch 옵션 : 3가지 ( method , header , body )
    let option = {
        method : "POST" , // (1) method
        headers : { "Content-Type" : "application/json" } , // (2) headers
        body : JSON.stringify(data) // (3) body
    }// option end

    // (3) fetch( url , option )
    //    .then( response => response.json() )  // 응답자료 타입변환
    //    .then( data => { } )                  // 타입변환된 자료
    //    .catch( error => { } )                // 통신간의 예외처리

    fetch("/board",option)
        .then( response => response.json() )
        .then( d => { console.log(d); } )
        .catch( e => { console.log(e); } ) // fetch end
}// func end

// 3. 전체조회
const boardPrint = ( ) => {
    console.log("boardPrint() exe");
    // (1) 보낼데이터 - 없음
    // (2) fetch option , GET 생략가능
    let option = { method : "GET" }
    // (3) fetch 실행
    fetch("/board" , option)
        .then( response => response.json() )
        .then( data => { console.log(data) } )
        .catch( error => { console.log(error) } )// fetch end
} // func end

// 4. 게시물 삭제
const boardDelete = ( ) => {
    console.log("boardDelete() exe");
    // (1) 보낼데이터
    let bno = 42; // 존재하는 bno 아무거나
    // (2) fetch option
    let option = { method : "DELETE" }// option end
    // (3) fetch 실행
    fetch(`/board?bno=${bno}` , option)
        .then( response => response.json() )
        .then( data => { console.log(data); } )
        .catch( error => { console.log(error); } ) // fetch end
}// func end

// 5. 게시물 수정
const boardUpdate = ( ) => {
    console.log("boardUpdate() exe");
    // (1) 보낼데이터
    let data = { "bno" : 1 , "bcontent" : "안녕하세요3" }
    // (2) fetch option
    let option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(data)
    }// option end
    fetch("/board",option)
        .then( response => response.json() )
        .then( d => { console.log(d); } )
        .catch( error => { console.log(error); } ) // fetch end
}// func end