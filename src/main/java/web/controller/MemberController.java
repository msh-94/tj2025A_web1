package web.controller;// 패키지명

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    // 로그인 기능
    @PostMapping("/login")
    public int login(@RequestBody MemberDto dto , HttpServletRequest request){
        int result = memberService.login(dto);
        HttpSession session = request.getSession();
        if (result > 0){
            session.setAttribute("logMno",result);
        }// if end
        return result;
    }// func end

    // 로그아웃 기능 , 세션은 서버를 재시작 하면 초기화
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        // 만약에 세션이 없거나 특정한 속성값이 없으면 (유효성검사) 비로그인상태
        if (session == null || session.getAttribute("logMno") == null){
            return false; // 비로그인상태
        }// if end
        session.removeAttribute("logMno");
        return true;
    }// func end

}// class end
