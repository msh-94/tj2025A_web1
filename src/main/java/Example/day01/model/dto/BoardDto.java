package Example.day01.model.dto; // 패키지명

public class BoardDto {// class start
    // 멤버변수 : private 필수 로 하고 db테이블 속성과 일치화 * 커스텀
    private int bno;
    private String bcontent;
    private String bwriter;
    // 생성자 , getter/setter , toString : 자동완성
    public BoardDto() {
    }
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
    public BoardDto(String bcontent, String bwriter) {
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    public int getBno() { return bno; }
    public void setBno(int bno) { this.bno = bno; }

    public String getBcontent() { return bcontent; }
    public void setBcontent(String bcontent) { this.bcontent = bcontent; }

    public String getBwriter() { return bwriter; }
    public void setBwriter(String bwriter) { this.bwriter = bwriter; }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}// class end
