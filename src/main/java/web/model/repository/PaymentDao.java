package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.PaymentDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class PaymentDao extends Dao{ // class start
    // 결제 등록 기능
    public boolean chargeAdd(PaymentDto dto){
        try{
            String sql = "insert into payment(mno , pamount) values( ? ,? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,dto.getMno());
            ps.setInt(2,dto.getPamount());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 최근 결제 조회 기능
    public PaymentDto chargePrint(int mno){
        try{
            String sql = "select * from payment where mno = ? order by pdate desc limit 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                PaymentDto dto = new PaymentDto();
                dto.setMno(rs.getInt("mno"));
                dto.setPno(rs.getInt("pno"));
                dto.setPamount(rs.getInt("pamount"));
                dto.setPdate(rs.getString("pdate"));
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end


}// class end
