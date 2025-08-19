package web.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.PointLogDto;
import web.model.repository.PointLogDao;

import java.util.List;

@Service
public class PointLogService { // class start
    // dao 불러오기
    private final PointLogDao pointLogDao;
    @Autowired
    public PointLogService(PointLogDao pointLogDao){
        this.pointLogDao = pointLogDao;
    }

    // 포인트 충전 기능
    public boolean pointLogAdd(PointLogDto dto){
        return pointLogDao.pointLogAdd(dto);
    }// func end

    // 특정회원 포인트 로그 전체 조회
    public List<PointLogDto> pointLogPrint(int mno){
        return pointLogDao.pointLogPrint(mno);
    }// func end

    // 포인트 합계 반환 기능
    public int pointSum(int mno){
        int result = pointLogDao.pointSum(mno);
        if (result <= 0){
            return 0;
        }// if end
        return result;
    }// func end


}// class end
