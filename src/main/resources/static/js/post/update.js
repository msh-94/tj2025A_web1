console.log('update.js 확인');

// 섬머노트 실행
$(document).ready(function() {
  $('#summernote').summernote({
        lang : 'ko-KR' ,   // 썸머노트 메뉴들 한글화
        minHeight : 300 , // 썸머노트 구역 최소 높이       
  });
});

// 기존 게시물 조회하기
const getPost = async() => {
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');
    try{
        const response = await fetch(`/post/view?pno=${pno}`)
        const data = await response.json();
        document.querySelector('.cno').value = data.cno;
        document.querySelector('.ptitle').value = data.ptitle;
        document.querySelector('.note-editable').innerHTML = data.pcontent;
    }catch(e){console.log(e);}
}// func end
getPost();

// 게시물 수정
const updatePost = async() => {
    const cno = document.querySelector('.cno').value;
    const ptitle = document.querySelector('.ptitle').value;
    const pcontent = document.querySelector('.pcontent').value;
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');
    const obj = { cno , ptitle , pcontent , pno }
    const option = { 
        method : "PUT" , 
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(obj)

    }
    try{
        const response = await fetch("/post",option);
        const data = await response.json();
        console.log(data);
        if(data > 0){
            alert('수정 성공');
            location.href=`/post/view.jsp?pno=${pno}`
        }else{
            alert('수정 실패');
        }// if end
    }catch(e){ console.log(e); }
}// func end