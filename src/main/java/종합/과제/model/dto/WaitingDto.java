package 종합.과제.model.dto;// 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class WaitingDto {// class start
    private int wno;
    private String phone;
    private int count;
    private String addDate;
}// class end
