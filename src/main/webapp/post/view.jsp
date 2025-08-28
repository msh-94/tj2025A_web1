<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div class="container">
        <div>
            <span> 제목 : <input type="text" class="ptitle"/></span>
            등록일 : <span class="pdate"></span>&nbsp;
            조회수 : <span class="pview"></span> <br/>
            내용 : <textarea class="pcontent" style="width: 500px; height: 500px"></textarea><br/>
            <div class="viewCheck"></div>
        </div>
        <div>
            <span>댓글작성 : <textarea class="longtext"></textarea> <button type="button" onclick="writeReply()"> 작성 </button></span>
        </div>
        <div class="reply">
            
        </div>
    </div>

    <script src="/js/post/view.js"></script>
</body>
</html>