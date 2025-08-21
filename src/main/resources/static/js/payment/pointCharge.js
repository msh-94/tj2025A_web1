console.log('pointCharge.js 확인');

// 연동
const checkout = new Checkout(
    "store-iamporttest_3", // 상점 ID
  "channel-key-66f2c31c-d64c-4be5-8727-3824bebf6790", // 채널 키
  )
checkout.load()

function Checkout() {
    let item = null
    this.load = async () => {
        const waitPortOne = new Promise((resolve) => {
            const polling = setInterval(() => {
                if (window.PortOne != null) {
                    clearInterval(polling)
                    resolve()
                }
            }, 50)
        })
        
        await Promise.all([waitPortOne, waitItem])
        window.loadingDialog.open = false
        window.checkoutDialog.open = true
        await this.showCheckout()
    }
    this.showCheckout = async () => {
        window.itemName.replaceChildren(item.name)
        window.itemImage.src = `/${item.id}.png`
        for (const priceElement of document.querySelectorAll(
            ".price-value",
        )) {
            priceElement.replaceChildren(`${item.price.toLocaleString()}원`)
        }
        window.checkoutDialog.onsubmit = async (e) => {
            e.preventDefault()
            this.setWaitingPayment(true)

            function randomId() {
                return [...crypto.getRandomValues(new Uint32Array(2))]
                    .map((word) => word.toString(16).padStart(8, "0"))
                    .join("")
            }

            const paymentId = randomId()
            const payment = await PortOne.requestPayment({
                storeId: "store-6ae5a54f-413b-4c84-812c-ad9152181b0d",
                channelKey: "channel-key-66f2c31c-d64c-4be5-8727-3824bebf6790",
                paymentId,
                orderName: item.name,
                totalAmount: item.price,
                currency: item.currency,
                payMethod: "CARD",
                customData: {
                    item: item.id,
                },
            })
            if (payment.code !== undefined) {
                this.setWaitingPayment(false)
                console.log(payment)
                this.openFailDialog(payment.message)
            }
            const completeResponse = await fetch("/api/payment/complete", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    paymentId: payment.paymentId,
                }),
            })
            this.setWaitingPayment(false)
            if (completeResponse.ok) {
                const paymentComplete = await completeResponse.json()
                if (paymentComplete.status === "PAID") {
                    this.openSuccessDialog()
                }
            } else {
                this.openFailDialog(await completeResponse.text())
            }
        }
        for (const dialogButton of document.getElementsByClassName(
            "closeDialog",
        )) {
            dialogButton.onclick = () => {
                dialogButton.parentElement.parentElement.open = false
            }
        }
        window.checkoutDialog.style = ""
    }
    this.setWaitingPayment = (isWaiting) => {
        window.checkoutButton.setAttribute("aria-busy", isWaiting.toString())
        window.checkoutButton.disabled = isWaiting
    }
    this.openFailDialog = (message) => {
        window.failMessage.replaceChildren(message)
        window.failDialog.open = true
    }
    this.openSuccessDialog = () => {
        window.successDialog.open = true
    }
}