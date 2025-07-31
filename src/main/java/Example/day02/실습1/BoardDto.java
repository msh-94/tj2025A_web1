package Example.day02.실습1;// 패키지명

public class BoardDto {// class start
    // 멤버변수
    private int bno;
    private String btitle;
    // 생성자
    public BoardDto() {
    }
    public BoardDto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }
    // getter/setter , toString()

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                '}';
    }
}// class end
