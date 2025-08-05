package 종합.실습3.controller;//패키지명

import org.springframework.web.bind.annotation.*;
import 종합.실습3.model.dao.WaitingDao;
import 종합.실습3.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController
public class WaitingController {// class start
    // dao 가져오기
    private WaitingDao dao = WaitingDao.getInstance();

    // 등록 기능
    @PostMapping("/wait")
    public boolean waitAdd(@RequestBody WaitingDto dto){
        boolean result = dao.waitAdd(dto);
        return result;
    }// func end

    // 전체조회 기능
    @GetMapping("/wait")
    public ArrayList<WaitingDto> waitPrint(){
        ArrayList<WaitingDto> result = dao.waitPrint();
        return result;
    }// func end

    // 대기 삭제 기능
    @DeleteMapping("/wait")
    public boolean waitDelete(@RequestParam int wno){
        boolean result = dao.waitDelete(wno);
        return result;
    }// func end

    // 대기 수정 기능
    @PutMapping("/wait")
    public boolean waitUpdate( @RequestBody WaitingDto dto){
        boolean result = dao.waitUpdate(dto);
        return result;
    }// func end

}// class end
