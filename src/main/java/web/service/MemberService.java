package web.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.repository.MemberDao;

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


}// class end
