package web.controller; // 패키지명

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.PostDto;
import web.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {// class start
    // service 가져오기
    private final PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    // 게시물 등록 기능
    @PostMapping
    public int writePost(@RequestBody PostDto dto , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        dto.setMno((int)session.getAttribute("logMno"));
        int result = postService.writePost(dto);
        return result;
    }// func end

}// class end
