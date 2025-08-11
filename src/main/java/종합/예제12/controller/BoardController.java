package 종합.예제12.controller;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController { // class start
    // service 불러오기
    @Autowired private BoardService boardService;

    // 등록 기능
    @PostMapping
    public boolean boardWrite(@RequestBody BoardDto dto){
        System.out.println("dto = " + dto);
        System.out.println("BoardController.boardWrite");
        boolean result = boardService.boardWrite(dto);
        return result;
    }// func end

    // 전체조회 기능
    @GetMapping
    public List<BoardDto> boardPrint(){
        System.out.println("BoardController.boardPrint");
        List<BoardDto> result = boardService.boardPrint();
        return result;
    }// func end

    // 특정게시물 조회 기능
    @GetMapping("/find")
    public BoardDto boardFind(@RequestParam int bno){
        System.out.println("bno = " + bno);
        System.out.println("BoardController.boardFind");
        BoardDto result = boardService.boardFind(bno);
        return result;
    }// func end

    // 게시물 삭제 기능
    @DeleteMapping
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("bno = " + bno);
        System.out.println("BoardController.boardDelete");
        boolean result = boardService.boardDelete(bno);
        return result;
    }// func end

    // 게시물 수정 기능
    @PutMapping
    public boolean boardUpdate(@RequestBody BoardDto dto){
        System.out.println("dto = " + dto);
        System.out.println("BoardController.boardUpdate");
        boolean result = boardService.boardUpdate(dto);
        return result;
    }// func end

}//class end
