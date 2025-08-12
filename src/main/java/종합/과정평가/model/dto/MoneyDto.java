package 종합.과정평가.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MoneyDto { // class start
    private int custno;
    private int salenol;
    private int pcost;
    private int amount;
    private int price;
    private String pcode;
    private String sdate;
}// class end
