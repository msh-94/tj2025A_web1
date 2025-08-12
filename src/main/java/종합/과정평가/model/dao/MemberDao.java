package 종합.과정평가.model.dao; // 패키지명

import org.springframework.stereotype.Repository;
import 종합.과정평가.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDao extends Dao{// class start

    // 마지막 회원번호 현재날짜 반환기능
    public MemberDto returnMember(){
        try{
            String sql = "select * from member_tbl_02 order by custno desc limit 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                LocalDate today = LocalDate.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String now = today.format(dateFormatter);
                MemberDto dto = new MemberDto();
                dto.setCustno(rs.getInt("custno"));
                dto.setJoindate(now);
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end

    // 회원등록 기능
    public boolean memberAdd(MemberDto dto){
        try{
            String sql = "insert into member_tbl_02 values(? , ? ,? ,? ,? ,? ,? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,dto.getCustno());
            ps.setString(2,dto.getCustname());
            ps.setString(3,dto.getPhone());
            ps.setString(4,dto.getAddress());
            ps.setString(5,dto.getJoindate());
            ps.setString(6,dto.getGrade());
            ps.setString(7,dto.getCity());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 회원목록 조회 기능
    public List<MemberDto> memberPrint(){
        List<MemberDto> list = new ArrayList<>();
        try{
            String sql = "select * from member_tbl_02";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MemberDto dto = new MemberDto();
                String 등급 = rs.getString("grade");
                if (등급.equals("A")){
                    등급 = "VIP";
                }else if (등급.equals("B")){
                    등급 = "일반";
                }else if (등급.equals("C")){
                    등급 = "직원";
                }// if end
                dto.setCustno(rs.getInt("custno"));
                dto.setCustname(rs.getString("custname"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setJoindate(rs.getString("joindate"));
                dto.setGrade(등급);
                dto.setCity(rs.getString("city"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // 회원정보 개별조회 기능
    public MemberDto memberFind(int custno){
        try{
            String sql = "select * from member_tbl_02 where custno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,custno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                MemberDto dto = new MemberDto();
                dto.setCustno(rs.getInt("custno"));
                dto.setCustname(rs.getString("custname"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setJoindate(rs.getString("joindate"));
                dto.setGrade(rs.getString("grade"));
                dto.setCity(rs.getString("city"));
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end

    // 회원정보 수정 기능
    public boolean memberUpdate(MemberDto dto){
        try{
            String sql = "update member_tbl_02 set custname = ? , phone = ? , address = ? , grade = ? , city = ? where custno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getCustname());
            ps.setString(2,dto.getPhone());
            ps.setString(3,dto.getAddress());
            ps.setString(4,dto.getGrade());
            ps.setString(5,dto.getCity());
            ps.setInt(6,dto.getCustno());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

}// class end
