package web.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.repository.MemberDao;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService { // class start
    // dao 가져오기
    private final MemberDao memberDao;
    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    public MemberService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    // 회원가입 기능
    public int signUp(MemberDto dto){
        int result = memberDao.signUp(dto);
        return result;
    }// func end

    // 로그인 기능
    public int login(MemberDto dto){
        int result = memberDao.login(dto);
        return result;
    }// func end

    // 내정보조회 기능
    public MemberDto info(int mno){
        MemberDto result = memberDao.info(mno);
        if (result != null){
            List<String> mimgname = memberDao.getMemberProfile(mno);
            result.setImages(mimgname);
        }// if end
        return result;
    }// func end

    // 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check(String type , String data){
        boolean result = memberDao.check(type, data);
        return result;
    }// func end

    // 회원정보 수정 기능
    public boolean update(MemberDto dto){
        boolean result = memberDao.update(dto);
        return result;
    }// func end

    // 비밀번호 수정기능
    public boolean updatePassword(Map<String,String> map , int mno){
        boolean result = memberDao.updatePassword(map,mno);
        return result;
    }// func end

    // 회원탈퇴 기능
    public boolean delete(int mno , String mpwd){
        boolean result = memberDao.delete(mno, mpwd);
        return result;
    }// func end

    // 아이디 찾기 기능
    public MemberDto idFind(String mname , String mphone){
        MemberDto result = memberDao.idFind(mname,mphone);
        return result;
    }// func end

    // 비밀번호 찾기 기능
    public String pwdFind(String mid , String mphone){
        String ranPwd = "";
        for (int i = 0; i < 5; i++){
            Random ran = new Random();
            int var = ran.nextInt(26)+97;
            char str = (char)var;
            ranPwd += str;
        }// for end
        boolean result = memberDao.pwdFind(mid, mphone , ranPwd);
        if (result) return ranPwd;
        return null;
    }// func end

    // 회원프로필 등록 기능
    public boolean createMemberProfile(int mno , String fileName){
        return memberDao.createMemberProfile(mno,fileName);
    }// func end   

}// class end
