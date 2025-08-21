package web.model.dto; // 패키지명

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class PaymentDto { // class start
    // 멤버변수
    private int pno;
    private int mno;
    private int pamount;
    private String pdate;
}// class end
