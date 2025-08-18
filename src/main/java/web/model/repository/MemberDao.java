package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Repository
public class MemberDao extends Dao { // class start
    // 회원가입 기능
    public int signUp(MemberDto dto){
        try{
            String sql = "insert into member (mid,mpwd,mname,mphone) values(? ,? ,? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS); // auto_increment(자동 pk)값 결과를 반환
            ps.setString(1,dto.getMid());
            ps.setString(2,dto.getMpwd());
            ps.setString(3,dto.getMname());
            ps.setString(4,dto.getMphone());
            int count = ps.executeUpdate();
            if (count == 1){
                // auto_increment 로 자동 할당된 pk값 반환하여 rs 로 조작하기
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()){ // 자동 할당된 pk값중에 첫번째 pk값 으로 이동
                    int mno = rs.getInt(1); // pk값 가져오기
                    return mno;
                }// if end
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    // 로그인 기능
    public int login(MemberDto dto){
        try{
            String sql = "select * from member where mid = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getMid());
            ps.setString(2,dto.getMpwd());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int logMno = rs.getInt("mno");
                return logMno;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    // 내정보 조회 기능
    public MemberDto info(int mno){
        try{
            String sql = "select * from member where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                MemberDto dto = new MemberDto();
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
                dto.setMname(rs.getString("mname"));
                dto.setMphone(rs.getString("mphone"));
                dto.setMdate(rs.getString("mdate"));
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end

    // 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check(String type , String data){
        try{
            String sql = "select * from member where "+type+" = ?"; // 속성명은 ? 안되서 +연산자로 넣어준다
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,data);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 회원정보 수정 기능
    public boolean update(MemberDto dto){
        try{
            String sql = "update member set mname = ? , mphone = ? where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getMname());
            ps.setString(2,dto.getMphone());
            ps.setInt(3,dto.getMno());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 비밀번호 수정 기능
    public boolean updatePassword(Map<String,String> map , int mno){
        try{
            String sql = "update member set mpwd = ? where mpwd = ? and mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,map.get("newPwd"));
            ps.setString(2,map.get("oldPwd"));
            ps.setInt(3,mno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 회원탈퇴 기능
    public boolean delete(int mno , String mpwd){
        try{
            String sql = "delete from member where mno = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ps.setString(2,mpwd);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 아이디 찾기 기능
    public MemberDto idFind(String mname , String mphone){
        try{
            String sql = "select mid from member where mname = ? and mphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,mname);
            ps.setString(2,mphone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                MemberDto result = new MemberDto();
                result.setMid(rs.getString("mid"));
                return result;
            }// if end
        }catch (Exception e){ System.out.println(e); }
        return null;
    }// func end

    // 비밀번호 찾기 기능
    public boolean pwdFind(String mid , String mphone , String ranPwd){
        try{
            String sql = "select * from member where mid = ? and mphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,mid);
            ps.setString(2,mphone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String pwd = "update member set mpwd = ? where mid = ? and mphone = ?";
                PreparedStatement ps1 = conn.prepareStatement(pwd);
                ps1.setString(1,ranPwd);
                ps1.setString(2,mid);
                ps1.setString(3,mphone);
                int count = ps1.executeUpdate();
                if (count == 1){
                    return true;
                }// if end
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end



}// class end
