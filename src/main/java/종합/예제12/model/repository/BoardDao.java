package 종합.예제12.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao{ // class start
    // 등록기능
    public boolean boardWrite(BoardDto dto){
        try{
            String sql = "insert into board(bcontent,bwriter) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getBcontent());
            ps.setString(2,dto.getBwriter());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); } // catch end
        return false;
    }// func end

    // 전체조회 기능
    public List<BoardDto> boardPrint(){
        List<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BoardDto dto = new BoardDto(rs.getInt("bno"),rs.getString("bcontent"),rs.getString("bwriter"));
                list.add(dto);
            }// while end
        } catch (SQLException e) { System.out.println(e); } // catch end
        return list;
    }// func end

    // 특정 게시물 조회
    public BoardDto boardFind(int bno){
        BoardDto dto = new BoardDto();
        try{
            String sql = "select * from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dto.setBno(rs.getInt("bno"));
                dto.setBcontent(rs.getString("bcontent"));
                dto.setBwriter(rs.getString("bwriter"));
            }// if end
        } catch (Exception e) { System.out.println(e); } // catch end
        return dto;
    }// func end

    // 게시물 삭제
    public boolean boardDelete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 게시물 수정 기능
    public boolean boardUpdate(BoardDto dto){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getBcontent());
            ps.setInt(2,dto.getBno());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

}// class end
