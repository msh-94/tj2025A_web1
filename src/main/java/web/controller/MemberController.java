package web.controller;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController { // class start
    // service 가져오기
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // 회원가입 기능
    @PostMapping("/signup")
    public int signUp(@RequestBody MemberDto dto){
        int result = memberService.signUp(dto);
        return result;
    }// func end

}// class end
