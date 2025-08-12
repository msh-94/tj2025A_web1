package 종합.과정평가.model.dao;// 패키지명

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MoneyDao extends Dao{// class start

    // 회원 매출조회 화면
    public List<Map<String,Object>> salesPrint(){
        List<Map<String,Object>> list = new ArrayList<>();
        try{
            String sql = "select m.custno , m.custname , m.grade , sum(mo.price) total from money_tbl_02 mo join member_tbl_02 m  " +
                    "on mo.custno = m.custno group by m.custno, m.custname, m.grade order by total desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String 등급 = rs.getString("grade");
                if (rs.getString("grade").equals("A")){
                    등급 = "VIP";
                }else if (rs.getString("grade").equals("B")){
                    등급 = "일반";
                }else if (rs.getString("grade").equals("C")){
                    등급 = "직원";
                }// if end
                Map<String,Object> map = new HashMap<>();
                map.put("회원번호",rs.getObject("custno"));
                map.put("회원성명",rs.getObject("custname"));
                map.put("고객등급",등급);
                map.put("매출",rs.getObject("total"));
                list.add(map);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

}// class end
