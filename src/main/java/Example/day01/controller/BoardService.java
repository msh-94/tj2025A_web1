package Example.day01.controller; // 패키지명

import Example.day01.model.dao.BoardDao;
import Example.day01.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class BoardService { // class start
    // 싱글톤
    private BoardService(){}
    private static final BoardService instance = new BoardService();
    public static BoardService getInstance(){ return instance; }

    // dao 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    /** 등록기능
     * @param bcontent
     * @param bwriter
     * @return boolean
     */
    @PostMapping
    public boolean boardWriter(String bcontent , String bwriter){
        // 1. 여러가지 유효성 검사 (패스)
        // 2. 데이터 문제없으면 묶음(객체)
        // --> 주의할점 매개변수와 동일한 생성자가 존재하지 않으면 오류 발생한다
        BoardDto dto = new BoardDto(bcontent,bwriter);
        // 3. 객체화 된 dto를 dao에게 전달후 결과를 받는다
        boolean result = boardDao.boardWrite(dto);
        // 4. 결과를 view 에게 리턴한다
        return result;
    }// func end


    @GetMapping
    // (2) 전체조회 구현
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint(); // dao에게 전달후 결과 받기
        return result; // view에게 리턴
    }// func end

    // (3) 삭제 구현
    public boolean boardDelete(int bno){
        boolean result = boardDao.boardDelete(bno);
        return result;
    }// func end

    // (4) 수정 구현
    public boolean boardUpdate(int bno , String bcontent){
        BoardDto dto = new BoardDto(bno,bcontent,null);
        boolean result = boardDao.boardUpdate(dto);
        return result;
    }// func end
}// class end
