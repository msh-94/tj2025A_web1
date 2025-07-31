package Example.day02.실습1;// 패키지명

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {// class start

    // [1] 글쓰기 POST  "/exam1/board" 매개변수x 리턴 boolean
    @PostMapping
    @ResponseBody
    public boolean 글쓰기(){
        System.out.println("BoardController.글쓰기");
        return true;
    }// func end

    // [2] 전체 글 조회 GET "/exam1/board" 매개변수 x , 리턴 List ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ]
    @GetMapping
    @ResponseBody
    public List<> 전체조회(){

    }

    // [3] 개별 글 조회 GET "/exam1/board/view" 매개변수 x , 리턴 MAP ,  {bno:'',btitle:''}

    // [4] 개별 글 수정 PUT "/exam1/board" 매개변수 x , 리턴 boolean

    // [5] 개별 글 삭제 DELETE "/exam1/board" 매개변수 x , int


}// class end
