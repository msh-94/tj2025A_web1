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

    <div id="container">
        <div>포인트충전 : <input type="text" id="amountInput"/></div>
        <button type="button" onclick="chargeAdd()"> 결제 </button>
    </div>

    <script src="https://cdn.portone.io/v2/browser-sdk.js" async defer></script>    
    <script src="/js/payment/pointCharge.js"></script>
</body>

</html>