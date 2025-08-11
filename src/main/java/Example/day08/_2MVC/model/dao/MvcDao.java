package Example.day08._2MVC.model.dao; // 패키지명

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // [3] Repository 빈 등록
public class MvcDao extends Dao {// class start
    // 다음 레이어(계층) 없어서 @Autowired 없다
    // extends Dao 할 경우 db연동 상속받아 사용한다
    public void method(){
        System.out.println("MvcDao.method"); // soutm 확인
        try{
            String sql = "select * from mvc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("var1"));
            }// while end
        } catch (Exception e) { System.out.println(e); }// catch end
    }// func end

}// class end
