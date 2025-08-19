package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.PointLogDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PointLogDao extends Dao{// class start

    // 포인트 로그 등록 기능
    public boolean pointLogAdd(PointLogDto dto){
        try {
            String sql = "insert into pointlog (mno,plpoint,plcomment) values( ? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,dto.getMno());
            ps.setInt(2,dto.getPlpoint());
            ps.setString(3,dto.getPlcomment());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 특정회원 포인트 로그 전체 조회
    public List<PointLogDto> pointLogPrint(int mno){
        List<PointLogDto> list = new ArrayList<>();
        try{
            String sql = "select * from pointlog where mno = ? order by pldate desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PointLogDto dto = new PointLogDto();
                dto.setPlpoint(rs.getInt("plpoint"));
                dto.setMno(rs.getInt("mno"));
                dto.setPlno(rs.getInt("plno"));
                dto.setPlcomment(rs.getString("plcomment"));
                dto.setPldate(rs.getString("pldate"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // 포인트 합계 반환 기능
    public int pointSum(int mno){
        try{
            String sql = "select sum(plpoint) total from pointlog group by mno having mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("total");
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end
}// class end
