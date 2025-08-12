package 종합.과정평가.controller; // 패키지명

import org.springframework.web.bind.annotation.*;
import 종합.과정평가.model.dto.MemberDto;
import 종합.과정평가.service.MemberService;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController { // class start
    // service 불러오기
    private final MemberService memberService;
    private MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // 회원등록 기능
    @PostMapping
    public boolean memberAdd(@RequestBody MemberDto dto){
        boolean result = memberService.memberAdd(dto);
        return result;
    }// func end

    // 회원목록 조회기능
    @GetMapping
    public List<MemberDto> memberPrint(){
        List<MemberDto> list = memberService.memberPrint();
        return list;
    }// func end

    // 회원정보 개별조회 기능
    @GetMapping("/find")
    public MemberDto memberFind(@RequestParam int custno){
        MemberDto result = memberService.memberFind(custno);
        return result;
    }// func end

    // 회원정보 수정기능
    @PutMapping
    public boolean memberUpdate(@RequestBody MemberDto dto){
        boolean result = memberService.memberUpdate(dto);
        return result;
    }// func end

    // 현재날짜 마지막회원번호 반환
    @GetMapping("/num")
    public MemberDto returnMember(){
        MemberDto result = memberService.returnMember();
        return result;
    }// func end

}// class end
