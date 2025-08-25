package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class PostDao extends Dao{ // class start

    // 게시물 등록 기능
    public int writePost(PostDto dto){
        try{
            String sql = "insert into post(ptitle,pcontent,mno,cno) values(? ,? ,? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,dto.getPtitle());
            ps.setString(2,dto.getPcontent());
            ps.setInt(3,dto.getMno());
            ps.setInt(4,dto.getCno());
            int count = ps.executeUpdate();
            if (count == 1){
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()){
                    int pno = rs.getInt("pno");
                    return pno;
                }// if end
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

}// class end
