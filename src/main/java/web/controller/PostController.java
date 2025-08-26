package web.controller; // 패키지명

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
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

    // 게시물 전체 조회
    @GetMapping("") // method : GET , url : localhost:8080/post?cno=1&page=1&count=5
    public PageDto findAllPost(@RequestParam(defaultValue = "1") int cno ,
                               @RequestParam(defaultValue = "1") int page ,
                               @RequestParam(defaultValue = "5") int count ,
                               @RequestParam(required = false) String key ,
                               @RequestParam(required = false) String keyword){
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입 할 수 있다.
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 존재하는 조건이 필수가 아닐때 required = false 속성을 사용한다.
        return postService.findAllPost(cno,page,count);
    }// func end

}// class end
