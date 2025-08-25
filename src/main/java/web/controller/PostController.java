package web.controller; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}// class end
