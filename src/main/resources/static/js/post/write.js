// 섬머노트 실행
$(document).ready(function() {
  $('#summernote').summernote({
        lang : 'ko-KR' ,   // 썸머노트 메뉴들 한글화
        minHeight : 300 , // 썸머노트 구역 최소 높이
        placeholder : '여기에 내용 입력해주세요' // 가이드라인
  });
});

console.log('write.js 확인');

// 등록기능
const onWrite = async() => {    
    // 1. 첨부파일 있는 게시물 : multipart/form vs 첨부파일은 없고 내용에 텍스트+이미지 포함
    const cno = document.querySelector('.cno').value;
    const ptitle = document.querySelector('.ptitle').value;
    const pcontent = document.querySelector('.pcontent').value;
    const obj = { cno , ptitle , pcontent }
    const option = { 
        method : "POST" , 
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(obj)

    }
    try{
        const response = await fetch("/post",option);
        const data = await response.json();
        console.log(data);
        if(data > 0){
            alert('등록 성공');
            location.href=`/post/post.jsp?cno=${cno}`
        }else{
            alert('등록 실패');
        }// if end
    }catch(e){ console.log(e); }
}// func end

