package 종합.예제12.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class BoardDto { // class start
    private int bno;
    private String bcontent;
    private String bwriter;
}// class end
