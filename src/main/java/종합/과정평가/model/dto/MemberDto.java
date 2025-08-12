package 종합.과정평가.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MemberDto {// class start
    private int custno;
    private String custname;
    private String phone;
    private String address;
    private String joindate;
    private String grade;
    private String city;
}// class end
