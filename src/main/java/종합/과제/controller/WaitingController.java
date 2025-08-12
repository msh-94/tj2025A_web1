package 종합.과제.controller;// 패키지명

import org.springframework.web.bind.annotation.*;
import 종합.과제.model.dto.WaitingDto;
import 종합.과제.service.WaitingService;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {// class start
    // service 불러오기
    private final WaitingService waitingService;
    private WaitingController(WaitingService waitingService){
        this.waitingService = waitingService;
    }// 생성자

    // 등록 기능
    @PostMapping
    public boolean waitAdd(@RequestBody WaitingDto dto){
        boolean result = waitingService.waitAdd(dto);
        return result;
    }// func end

    // 전체조회 기능
    @GetMapping
    public List<WaitingDto> waitPrint(){
        List<WaitingDto> list = waitingService.waitPrint();
        return list;
    }// func end

    // 특정 대기현황 조회 기능
    @GetMapping("/find")
    public WaitingDto waitFind(@RequestParam int wno){
        WaitingDto dto = waitingService.waitFind(wno);
        return dto;
    }// func end

    // 대기 삭제 기능
    @DeleteMapping
    public boolean waitDelete(@RequestParam int wno){
        boolean result = waitingService.waitDelete(wno);
        return result;
    }// func end

    // 대기 수정 기능
    @PutMapping
    public boolean waitUpdate(@RequestBody WaitingDto dto){
        boolean result = waitingService.waitUpdate(dto);
        return result;
    }// func end



}// class end
