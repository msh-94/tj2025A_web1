package 종합.실습4.model.dao; // 패키지명

import lombok.Getter;
import 종합.실습4.model.dto.WaitDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WaitDao { // class start
    // 싱글톤
    @Getter
    private static final WaitDao instance = new WaitDao();
    private WaitDao(){connect();}

    // db 정보
    private String db_url = "jdbc:mysql://localhost:3306/실습4";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    // db연동 코드
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        } catch (Exception e) { System.out.println(e); }
    }// func end

    // 대기 등록 기능
    public boolean waitAdd(WaitDto dto){
        try{
            String sql = "insert into wait(phone,count) values(? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getPhone());
            ps.setInt(2,dto.getCount());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 전체조회 기능
    public List<WaitDto> waitPrint(){
        List<WaitDto> list = new ArrayList<>();
        try{
            String sql = "select * from wait";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaitDto dto = new WaitDto();
                dto.setWno(rs.getInt("wno"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                dto.setWdate(rs.getString("wdate"));
                list.add(dto);
            }// while end
        }catch (Exception e){ System.out.println(e); }
        return list;
    }// func end


}// class end
