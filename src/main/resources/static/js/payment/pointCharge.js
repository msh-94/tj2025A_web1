console.log('pointCharge.js 확인');

// 결제 기능
const chargeAdd = async() => {
    const amountInput = document.querySelector("#amountInput").value;
    // 결제창 연동
    const response = await PortOne.requestPayment({    
        // Store ID 설정
        storeId: "store-6ae5a54f-413b-4c84-812c-ad9152181b0d",
        // 채널 키 설정
        channelKey: "channel-key-66f2c31c-d64c-4be5-8727-3824bebf6790",
        paymentId: `payment-${crypto.randomUUID()}`,
        orderName: "포인트 충전",
        totalAmount: amountInput,
        currency: "CURRENCY_KRW",
        payMethod: "CARD",
    });
}// func end



// 결제완료처리
// async function requestPayment() {
//   const response = await PortOne.requestPayment({
//     /* 파라미터 생략 */
//   });

//   if (response.code !== undefined) {
//     // 오류 발생
//     return alert(response.message);
//   }