package 종합.실습4.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WaitDto {// class start
    // 멤버변수
    private int wno;
    private String phone;
    private int count;
    private String wdate;
}// class end
