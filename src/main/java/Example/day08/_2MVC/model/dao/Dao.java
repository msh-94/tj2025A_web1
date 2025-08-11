package Example.day08._2MVC.model.dao; // 패키지명

import java.sql.Connection;
import java.sql.DriverManager;

// 여러개 DAO를 연동하는 중복 코드를 관리하는 슈퍼클래스
public class Dao { // class start
    // DB연동 계정정보
    private String db_url = "jdbc:mysql://localhost:3306/spring08";
    private String db_user = "root";
    private String db_password = "1234";
    // DB연동 멤버변수
    public Connection conn;
    // DB연동 생성자
    public Dao(){ connect(); }
    // DB연동 함수
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url, db_user, db_password );
            System.out.println("Dao.connect"); // 연동 확인용
        }catch( ClassNotFoundException e ){
            System.out.println("[경고] DB드라이버 연동 실패!" + e );
        }catch ( Exception e ){
            System.out.println("[경고] DB연동 실패!" + e );
        }//catch end
    }//func end

}// class end
