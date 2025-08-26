package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                    int pno = rs.getInt(1);
                    return pno;
                }// if end
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    // 카테고리별 게시물 수 조회
    public int getTotalCount(int cno){
        try{
            String sql = "select count(*) from post where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    /**
     * @param cno
     * @param startRow
     * @param count
     * @return List<PostDto>
     */
    // 카테고리별 게시물 전체조회
    public List<PostDto> findAll(int cno , int startRow , int count){
        List<PostDto> list = new ArrayList<>();
        try {
            String sql = "select * from post p join member m on p.mno = m.mno where cno = ? order by pno desc limit ? , ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setInt(2,startRow);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PostDto dto = new PostDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPtitle(rs.getString("ptitle"));
                dto.setPcontent(rs.getString("pcontent"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPview(rs.getInt("pview"));
                dto.setMno(rs.getInt("mno"));
                dto.setCno(rs.getInt("cno"));
                dto.setMid(rs.getString("mid"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // 카테고리별 검색 게시물 수 조회
    public int getTotalCountSearch(int cno,String key ,String keyword){
        try{
            String sql = "select count(*) from post where cno = ? and "+key+" like %"+keyword+"%";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    // 카테고리별 게시물 검색 전체조회
    public List<PostDto> findAllSearch(int cno , int startRow , int count , String key , String keyword){
        List<PostDto> list = new ArrayList<>();
        try {
            String sql = "select * from post p join member m on p.mno = m.mno where cno = ? and "+key+" like %"+keyword+"% order by pno desc limit ? , ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setInt(2,startRow);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PostDto dto = new PostDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPtitle(rs.getString("ptitle"));
                dto.setPcontent(rs.getString("pcontent"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPview(rs.getInt("pview"));
                dto.setMno(rs.getInt("mno"));
                dto.setCno(rs.getInt("cno"));
                dto.setMid(rs.getString("mid"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

}// class end
