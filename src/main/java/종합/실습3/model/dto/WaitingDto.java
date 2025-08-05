package 종합.실습3.model.dto; // 패키지명

public class WaitingDto {// class start
    // 멤버변수
    private int wno;
    private String phone;
    private int count;
    // 생성자
    public WaitingDto() { }
    public WaitingDto(int wno, String phone, int count) {
        this.wno = wno;
        this.phone = phone;
        this.count = count;
    }
    // getter/setter , toString()
    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}// class end
