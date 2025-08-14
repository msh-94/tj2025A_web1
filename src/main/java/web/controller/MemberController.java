package web.controller;// 패키지명

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

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

    // 내정보조회 기능
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request){
        HttpSession session = request.getSession();
        // 만약에 세션이 없거나 특정한 속성값이 없으면 (유효성검사) 비로그인상태
        if (session == null || session.getAttribute("logMno") == null){
            return null; // 비로그인상태
        }// if end
        int mno = (int)session.getAttribute("logMno");
        MemberDto result = memberService.info(mno);
        return result;
    }// func end

    // 특정한 필드/열/컬럼 의 값 중복/존재 확인
    @GetMapping("/check")
    public boolean check(@RequestParam String type , @RequestParam String data){
        boolean result = memberService.check(type, data);
        return result;
    }// func end

    // 회원정보 수정 기능
    @PutMapping("/update")
    public boolean update(@RequestBody MemberDto dto , HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        dto.setMno(mno);
        boolean result = memberService.update(dto);
        return result;
    }// func end

    // 비밀번호 수정기능
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String,String> map , HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        boolean result = memberService.updatePassword(map,mno);
        if (result)session.removeAttribute("logMno");
        return result;
    }// func end

    // 회원탈퇴 기능
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String mpwd , HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        boolean result = memberService.delete(mno , mpwd);
        if(result)session.removeAttribute("logMno");
        return result;
    }// func end

    // 아이디 찾기 기능
    @GetMapping("/idfind")
    public MemberDto idFind(@RequestParam String mname , @RequestParam String mphone){
        MemberDto result = memberService.idFind(mname,mphone);
        return result;
    }// func end

    // 비밀번호 찾기 기능
    @GetMapping("/pwdfind")
    public String pwdFind(@RequestParam String mid , @RequestParam String mphone){
        String result = memberService.pwdFind(mid, mphone);
        return result;
    }// func end

}// class end
