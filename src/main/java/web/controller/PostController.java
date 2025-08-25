package web.controller; // 패키지명

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.PostDto;
import web.service.PostService;

@RestController // http 요청/응답 자료 매핑 기술
@RequestMapping("/post") // http url 매핑 기술
@RequiredArgsConstructor // final 변수에 대한 자동 생성자 주입
public class PostController {// class start
    // service 가져오기
    private final PostService postService;

    // 게시물 등록 기능
    @PostMapping("") // method : POST , url : localhost:8080/post , body : { btitle : , bcontent : , cno : }
    public int writePost(@RequestBody PostDto dto , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        dto.setMno((int)session.getAttribute("logMno"));
        int result = postService.writePost(dto);
        return result;
    }// func end

}// class end
