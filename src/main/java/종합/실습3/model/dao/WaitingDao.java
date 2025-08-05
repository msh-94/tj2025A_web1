package 종합.실습3.model.dao; // 패키지명


import com.sun.jdi.event.ExceptionEvent;
import 종합.실습3.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao { // class start
    // 싱글톤
    private WaitingDao(){connect();};
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){return instance;}

    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/실습3";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch (Exception e ){ System.out.println(e);   }
    }// func end

    // 등록 기능
    public boolean waitAdd(WaitingDto dto){
        try{
            String sql = "insert into waiting(phone , count) values(? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getPhone());
            ps.setInt(2,dto.getCount());
            int count = ps.executeUpdate();
            if (count == 1)return true;
            return false;
        }catch (Exception e){ System.out.println(e); }
        return false;
    }// func end

    // 전체조회 기능
    public ArrayList<WaitingDto> waitPrint(){
        ArrayList<WaitingDto> list = new ArrayList<>();
        try{
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaitingDto dto = new WaitingDto();
                dto.setWno(rs.getInt("wno"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // 대기 취소 기능
    public boolean waitDelete(int wno){
        try{
            String sql = "delete from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
            return false;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 대기 수정 기능
    public boolean waitUpdate(WaitingDto dto){
        try{
            String sql = "update waiting set count = ? where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,dto.getCount());
            ps.setInt(2,dto.getWno());
            int count = ps.executeUpdate();
            if (count == 1) return true;
            return false;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

}// class end
