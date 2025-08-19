package web.model.dto;// 패키지명

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class PointLogDto {// class start
    private int plno;
    private int mno;
    private int plpoint;
    private String plcomment;
    private String pldate;
}// class end
