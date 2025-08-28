console.log('view.js 확인');

// 개별 게시물 조회
const getPost = async() => {    
    const pdate = document.querySelector('.pdate');
    const pview = document.querySelector('.pview');
    const pcontent = document.querySelector('.pcontent'); 
    const check = document.querySelector('.viewCheck');   
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');
    try{
        const response = await fetch(`/post/view?pno=${pno}`);
        const data = await response.json();     console.log(data);
        document.querySelector('.ptitle').value = data.ptitle;
        pdate.innerHTML = data.pdate;
        pview.innerHTML = data.pview;
        pcontent.innerHTML = data.pcontent;
        if(data.host == true){
            let html = `<button type="button" onclick="location.href='/post/update.jsp?pno=${pno}'"> 수정 </button> <button type="button" onclick="deletePost()"> 삭제 </button>`
            check.innerHTML = html;
        }// if end
    }catch(e){ console.log(e); }
}// func end
getPost();

// 개별 게시물 삭제 기능
const deletePost = async() => {
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');
    const option = { method : "DELETE"}
    try{
        const response = await fetch(`/post?pno=${pno}`,option);
        const data = await response.json();
        if(data == true){
            alert('삭제 성공');
            location.href="/post/post.jsp";
        }else{
            alert('삭제 실패');
        }//if end
    }catch(e){ console.log(e); }
}// func end


// 댓글 작성 기능
const writeReply = async() => {
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');
    const longtext = document.querySelector('.longtext').value;
    const obj = {longtext , pno}
    const option = {
        method : "POST" , 
        headers : {"Content-Type" : "application/json"} , 
        body : JSON.stringify(obj)
    }// option end
    try{
        const response = await fetch("/post/reply",option);
        const data = await response.json();
        if(data > 0){
            alert('댓글 작성 성공');
            findAllReply();
        }else{
            alert('댓글 작성 실패');
        }// if end        
    }catch(e){ console.log(e); }
}// func end

// 댓글 전체 조회
const findAllReply = async() =>{
    const param = new URL(location.href).searchParams;
    const pno = param.get('pno');   console.log(pno);
    const reply = document.querySelector('.reply');
    let html = "";
    try{
        const response = await fetch(`/post/reply?pno=${pno}`);
        const data = await response.json();     console.log(data);
        for(let i = 0; i < data.length; i++){
            let da = data[i];
            html += `작성자 : <span class="mid">${da.mid}</span> 작성일 : <span class="rdate">${da.rdate}</span><br/>
            내용 : <textarea class="rcontent" style="height: 18px; width: 210px;">${da.rcontent}</textarea><br/>`
        }// for end
        reply.innerHTML = html;
    }catch(e){ console.log(e); }
}// func end
findAllReply();


