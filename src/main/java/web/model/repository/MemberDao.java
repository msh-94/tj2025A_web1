package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

}// class end
