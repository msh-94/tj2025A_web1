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

    <div id="root">        
        <main id="checkoutDialog" style="display: none">
            <form id="checkoutForm">
                <article>
                    <div class="item">                        
                        <div class="item-text">
                            <h5 id="itemName">10.000point 충전</h5>
                            <p class="price-value">10.000원</p>
                        </div>
                    </div>
                    <div class="price">
                        <label>총 구입 가격</label>
                        <span class="price-value" />
                    </div>
                </article>
                <button id="checkoutButton" type="submit">결제</button>
            </form>
        </main>        
    </div>
    
    <script src="https://cdn.portone.io/v2/browser-sdk.js" async defer></script>    
    <script src="/js/payment/pointCharge.js"></script>
</body>

</html>