package 종합.과제.service;// 패키지명

import org.springframework.stereotype.Service;
import 종합.과제.model.dao.WaitingDao;
import 종합.과제.model.dto.WaitingDto;

import java.util.List;
@Service
public class WaitingService {// class start
    // dao 불러오기
    private final WaitingDao waitingDao;
    private WaitingService(WaitingDao waitingDao){
        this.waitingDao = waitingDao;
    }// 생성자

    // 등록 기능
    public boolean waitAdd(WaitingDto dto){
        boolean result = waitingDao.waitAdd(dto);
        return result;
    }// func end

    // 전체조회 기능
    public List<WaitingDto> waitPrint(){
        List<WaitingDto> list = waitingDao.waitPrint();
        return list;
    }// func end

    // 특정 대기현황 조회 기능
    public WaitingDto waitFind(int wno){
        WaitingDto dto = waitingDao.waitFind(wno);
        return dto;
    }// func end

    // 대기 삭제 기능
    public boolean waitDelete(int wno){
        boolean result = waitingDao.waitDelete(wno);
        return result;
    }// func end

    // 대기 수정 기능
    public boolean waitUpdate(WaitingDto dto){
        boolean result = waitingDao.waitUpdate(dto);
        return result;
    }// func end


}// class end
