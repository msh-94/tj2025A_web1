package 종합.실습4.controller;// 패키지명

import org.springframework.web.bind.annotation.*;
import 종합.실습4.model.dao.WaitDao;
import 종합.실습4.model.dto.WaitDto;

import java.util.List;

@RestController
@RequestMapping("/wait")
public class WaitController { // class start
    // dao 불러오기
    private WaitDao waitDao = WaitDao.getInstance();

    // 등록 기능
    @PostMapping("/add")
    public boolean waitAdd(@RequestBody WaitDto dto){
        System.out.println("WaitController.waitAdd");
        System.out.println("dto = " + dto);
        boolean result = waitDao.waitAdd(dto);
        return result;
    }// func end

    // 대기 전체 조회 기능
    @GetMapping("/print")
    public List<WaitDto> waitPrint(){
        System.out.println("WaitController.waitPrint");
        List<WaitDto> list = waitDao.waitPrint();
        return list;
    }// func end


}// class end
