package 종합.예제11.controller;// 패키지명

import org.springframework.web.bind.annotation.*;
import 종합.예제11.model.dao.BoardDao;
import 종합.예제11.model.dto.BoardDto;

import java.util.ArrayList;

@RestController // 싱글톤 대신에 사용할 수 있다.
public class BoardController {// class start
    // (*) boardDao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // (1) 등록 기능 구현
    @PostMapping("/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        // 3. 객체화 된 dto를 dao에게 전달후 결과를 받는다.
        boolean result = boardDao.boardWrite( boardDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }// func end

    // (2) 전체조회 구현
    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint(); // dao에게 전달후 결과 받기
        return result; // view에게 리턴
    }// func end

    // (3) 삭제 구현
    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam int bno){
        boolean result = boardDao.boardDelete(bno);
        return result;
    }// func end

    // (4) 수정 구현
    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto dto){
        boolean result = boardDao.boardUpdate(dto);
        return result;
    }// func end

}// class end
