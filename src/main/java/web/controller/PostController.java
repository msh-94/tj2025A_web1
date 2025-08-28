package web.controller; // 패키지명

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("")
    // 검색이 없을때 : method : GET , url : localhost:8080/post?cno=1&page=1&count=5 , 1번카테고리(뉴스)의 1페이지의 5개 게시물
    // 검색이 있을때 : method : GET , url : localhost:8080/post?cno=1&page=1&count=5&key=ptitle&keyword=ai , 1번카테고리(뉴스)의 1페이지의 5개 게시물제목 ai포함된 게시물
    public PageDto findAllPost(@RequestParam(defaultValue = "1") int cno ,
                               @RequestParam(defaultValue = "1") int page ,
                               @RequestParam(defaultValue = "5") int count ,
                               @RequestParam(required = false) String key ,
                               @RequestParam(required = false) String keyword){
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입 할 수 있다.
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 존재하는 조건이 필수가 아닐때 required = false 속성을 사용한다.(기본값 true)
        return postService.findAllPost(cno,page,count, key , keyword);
    }// func end

    // 게시물 개별 조회 getPost
    @GetMapping("/view")
    public PostDto getPost(@RequestParam int pno , HttpSession session){
        // HTTPSession : 브라우저 마다의 별도의 저장소 개념
            // 1. 세션 속성내 'viewHistory'(클라이언트가 조회한 게시물 정보) 값 가져오기
        Object object = session.getAttribute("viewHistory");
        Map<Integer,String> viewHistory;
            // 2. 만약에 'viewHistory' 존재하지 않으면
        if (object == null){
            viewHistory = new HashMap<>();
        }else {// 3. 존재하면 기존 자료를 타입변환 한다
            viewHistory = (Map<Integer , String>) object;
        }// if end
        // [1] 24시간내 하나의 게시물의 1번만 조회수 증가 요청 가능
            // 4. 오늘의 날짜를 문자열로 가져옴 , LocalDate.now() : 현재 시스템 날짜 변환함수
        String today = LocalDate.now().toString();
            // 5. 현재 게시물(pno)을 오늘(today) 조합하여 본 기록을 체크한다.
        String check = viewHistory.get(pno);
        if (check == null || !check.equals(today)){ // 만약에 현재게시물의 오늘날짜가 없거나 오늘날짜가 일치하지않으면
            // 6. 조회수 증가 서비스 호출
            postService.incrementView(pno);
            // 7. 세션에 조회수 기록/저장
            viewHistory.put(pno , today);
            // 8. 세션 속성 업데이트
            session.setAttribute("viewHistory" , viewHistory);
        }// if end
        // [2] 요청한 사람(클라이언트)이 본인이 작성한 글인지 확인
        PostDto result = postService.getPost(pno);
            // 로그인 세션 확인
        Object loginObject = session.getAttribute("logMno"); // 로그인 세션 확인
        int loginMno = loginObject == null ? 0 : (int) loginObject; // 만약에 로그인정보가 없으면 0 있으면 타입변환
        // 만약에 조회한 게시물의 작성자 회원번호 가 로그인 회원번호와 같으면 host 속성을 true
        if (result.getMno() == loginMno){ result.setHost(true); }
        return result;
    }// func end

    // 게시물 개별 삭제
    @DeleteMapping("")
    public boolean deletePost(@RequestParam int pno , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int) session.getAttribute("logMno");
        PostDto dto = postService.getPost(pno);
        if (dto.getMno() == mno){
            boolean result = postService.deletePost(pno);
            return result;
        }// inf end
        return false;
    }// func end

    // 게시물 수정
    @PutMapping("")
    public int updatePost(@RequestBody PostDto dto , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        int mno = (int) session.getAttribute("logMno");
        PostDto post = postService.getPost(dto.getPno());
        if (post.getMno() == mno){
            int result = postService.updatePost(dto);
            return result;
        }// inf end
        return 0;
    }// func end

    // 댓글 등록
    @PostMapping("/reply")
    public int writeReply(@RequestBody Map<String,String> map , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        int mno = (int) session.getAttribute("logMno");
        map.put("mno" , mno+"");
        int result = postService.writeReply(map);
        return result;
    }// func end

    // 댓글 전체 조회
    @GetMapping("/reply")
    public List<Map<String,String>> findAllReply(@RequestParam int pno ){
        return postService.findAllReply(pno);
    }// func end

}// class end
