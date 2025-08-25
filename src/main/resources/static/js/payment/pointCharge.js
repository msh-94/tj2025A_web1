console.log('pointCharge.js 확인');

// 결제 기능
const chargeAdd = async () => {
    const amountInput = document.querySelector("#amountInput").value;

    // 결제창 연동
    const response = await PortOne.requestPayment({
        storeId: "store-6ae5a54f-413b-4c84-812c-ad9152181b0d",
        channelKey: "channel-key-66f2c31c-d64c-4be5-8727-3824bebf6790",
        paymentId: `payment-${crypto.randomUUID()}`,
        orderName: "포인트 충전",
        totalAmount: amountInput,
        currency: "CURRENCY_KRW",
        payMethod: "CARD",
    });

    // 응답 처리
    if (response.code !== undefined) {
        // 오류 발생
        alert("결제에 실패했습니다: " + response.message);
        return;
    }

    // 결제 성공 시 서버에 결제 정보 전송 (예시 URL 사용)
    try {
        const serverResponse = await fetch('/api/payment/complete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                paymentId: response.paymentId,
                amount: response.totalAmount,
                orderName: response.orderName,
                approvedAt: response.approvedAt, // 결제 승인 시간
                method: response.method, // 결제 수단
                status: response.status,
                transactionKey: response.transactionKey
            })
        });

        const result = await serverResponse.json();

        if (serverResponse.ok) {
            alert("결제가 성공적으로 완료되었습니다!");
            // 포인트 반영 등 후속 처리
            location.reload(); // 또는 UI 업데이트
        } else {
            alert("서버와 통신 중 문제가 발생했습니다: " + result.message);
        }

    } catch (error) {
        console.error("서버 통신 오류:", error);
        alert("결제는 완료되었지만, 서버와의 통신에 실패했습니다.");
    }
};