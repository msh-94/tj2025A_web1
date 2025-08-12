package 종합.과제.model.dao; // 패키지명

import org.springframework.stereotype.Repository;
import 종합.과제.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao{// class start
    // 등록기능
    public boolean waitAdd(WaitingDto dto){
        try{
            String sql = "insert into waiting(phone,count) values(? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getPhone());
            ps.setInt(2,dto.getCount());
            int result = ps.executeUpdate();
            if (result == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 전체조회 기능
    public List<WaitingDto> waitPrint(){
        List<WaitingDto> list = new ArrayList<>();
        try{
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaitingDto dto = new WaitingDto();
                dto.setWno(rs.getInt("wno"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                dto.setAddDate(rs.getString("addDate"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // 특정 대기 조회 기능
    public WaitingDto waitFind(int wno){
        try{
            String sql = "select * from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                WaitingDto dto = new WaitingDto();
                dto.setWno(rs.getInt("wno"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                dto.setAddDate(rs.getString("addDate"));
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end

    // 대기 삭제 기능
    public boolean waitDelete(int wno){
        try {
            String sql = "delete from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 대기 수정 기능
    public boolean waitUpdate(WaitingDto dto){
        try{
            String sql = "update waiting set phone = ? , count = ? where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getPhone());
            ps.setInt(2,dto.getCount());
            ps.setInt(3,dto.getWno());
            int result = ps.executeUpdate();
            if (result == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

}// class end
