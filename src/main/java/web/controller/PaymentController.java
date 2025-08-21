package web.controller; // 패키지명

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.PaymentDto;
import web.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController { // class start
    // service 불러오기
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    // 결제 등록 기능
    @PostMapping("/add")
    public boolean chargeAdd(@RequestBody PaymentDto dto, HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        dto.setMno(mno);
        boolean result = paymentService.chargeAdd(dto);
        return result;
    }// func end

    // 결제 취소 기능
    @PostMapping("/cancle")
    public boolean chargeCancel(HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        boolean result = paymentService.chargeCancel(mno);
        return result;
    }// func end

}// class end
