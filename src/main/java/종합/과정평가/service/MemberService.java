package 종합.과정평가.service;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.과정평가.model.dao.MemberDao;
import 종합.과정평가.model.dto.MemberDto;

import java.util.List;

@Service
public class MemberService {// class start
    // dao 불러오기
    private final MemberDao memberDao;
    @Autowired
    public MemberService(MemberDao memberDao ){
        this.memberDao = memberDao;
    }

    // 회원 등록 기능
    public boolean memberAdd(MemberDto dto){
        boolean result = memberDao.memberAdd(dto);
        return result;
    }// func end

    // 회원목록 조회기능
    public List<MemberDto> memberPrint(){
        List<MemberDto> list = memberDao.memberPrint();
        return list;
    }// func end

    // 회원정보 개별조회 기능
    public MemberDto memberFind(int custno){
        MemberDto result = memberDao.memberFind(custno);
        return result;
    }// func end

    // 회원정보 수정 기능
    public boolean memberUpdate(MemberDto dto){
        boolean result = memberDao.memberUpdate(dto);
        return result;
    }// func end

    // 현재날짜 마지막회원번호 반환
    public MemberDto returnMember(){
        MemberDto result = memberDao.returnMember();
        return result;
    }// func end


}// class end
