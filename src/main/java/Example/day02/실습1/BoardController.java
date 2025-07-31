package Example.day02.실습1;// 패키지명

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {// class start

    // [1] 글쓰기 POST  "/exam1/board" 매개변수x 리턴 boolean
    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean 글쓰기(){
        System.out.println("BoardController.글쓰기");
        return true;
    }// func end

    // [2] 전체 글 조회 GET "/exam1/board" 매개변수 x , 리턴 List ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ]
    @GetMapping("/exam1/board")
    @ResponseBody
    public List<BoardDto> 전체조회(){
        System.out.println("BoardController.전체조회");
        List<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto());
        list.add(new BoardDto());
        list.add(new BoardDto());
        return list;
    }// func end

    // [3] 개별 글 조회 GET "/exam1/board/view" 매개변수 x , 리턴 MAP ,  {bno:'',btitle:''}
    @GetMapping("/exam1/view")
    @ResponseBody
    public Map<Integer,String> 개별조회(){
        System.out.println("BoardController.개별조회");
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"유재석");
        return map;
    }// func end

    // [4] 개별 글 수정 PUT "/exam1/board" 매개변수 x , 리턴 boolean
    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean 수정(){
        System.out.println("BoardController.수정");
        return true;
    }// func end

    // [5] 개별 글 삭제 DELETE "/exam1/board" 매개변수 x , int
    @DeleteMapping("/exam1/board")
    @ResponseBody
    public int 삭제(){
        System.out.println("BoardController.삭제");
        return 3;
    }// func end


}// class end
