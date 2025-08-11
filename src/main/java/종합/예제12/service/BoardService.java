package 종합.예제12.service;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.model.repository.BoardDao;

import java.util.List;

@Service
public class BoardService {// class start
    // dao 불러오기
    @Autowired private BoardDao boardDao;

    // 등록 기능
    public boolean boardWrite(BoardDto dto){
        boolean result = boardDao.boardWrite(dto);
        return result;
    }// func end

    // 전체조회 기능
    public List<BoardDto> boardPrint(){
        List<BoardDto> result = boardDao.boardPrint();
        return result;
    }// func end

    // 특정게시물 조회 기능
    public BoardDto boardFind(int bno){
        BoardDto result = boardDao.boardFind(bno);
        return result;
    }// func end

    // 게시물 삭제 기능
    public boolean boardDelete(int bno){
        boolean result = boardDao.boardDelete(bno);
        return result;
    } // func end

    // 게시물 수정 기능
    public boolean boardUpdate(BoardDto dto){
        boolean result = boardDao.boardUpdate(dto);
        return result;
    }// func end

}// class end
