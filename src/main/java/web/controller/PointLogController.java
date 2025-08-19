package web.controller;// 패키지명

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PointLogDto;
import web.service.PointLogService;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointLogController { // class start
    // service 불러오기
    private final PointLogService pointLogService;
    @Autowired
    public PointLogController(PointLogService pointLogService){
        this.pointLogService = pointLogService;
    }

    // 포인트 충전 기능
    @PostMapping("/add")
    public boolean pointLogAdd(@RequestBody PointLogDto dto , HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return false;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        dto.setMno(mno);
        return pointLogService.pointLogAdd(dto);
    }// func end

    // 특정회원 포인트 로그 전체 조회
    @GetMapping("/print")
    public List<PointLogDto> pointLogPrint(HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return null;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        List<PointLogDto> list = pointLogService.pointLogPrint(mno);
        return list;
    }// func end

    // 포인트 합계 반환 기능
    @GetMapping("/total")
    public int pointSum(HttpSession session){
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        int mno = (int)session.getAttribute("logMno");
        int result = pointLogService.pointSum(mno);
        return result;
    }// func end



}// class end
