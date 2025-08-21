package web.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.PaymentDto;
import web.model.dto.PointLogDto;
import web.model.repository.PaymentDao;

@Service
public class PaymentService { // class start
    // dao 불러오기 , service 불러오기
    private final PaymentDao paymentDao;
    private final PointLogService pointLogService;
    @Autowired
    public PaymentService(PaymentDao paymentDao , PointLogService pointLogService){
        this.paymentDao = paymentDao;
        this.pointLogService = pointLogService;
    }

    // 결제 등록 기능
    public boolean chargeAdd(PaymentDto dto){
        boolean result = paymentDao.chargeAdd(dto);
        if (result){
            PointLogDto pdto = new PointLogDto();
            pdto.setPlcomment("포인트충전");
            pdto.setPlpoint(dto.getPamount());
            pdto.setMno(dto.getMno());
            pointLogService.pointLogAdd(pdto);
            int bonus = (int) (dto.getPamount() * 0.05);
            PointLogDto pdto2 = new PointLogDto();
            pdto2.setPlcomment("충전보너스");
            pdto2.setMno(dto.getMno());
            pdto2.setPlpoint(bonus);
            pointLogService.pointLogAdd(pdto2);
        }// if end
        return result;
    }// func end

    // 결제 취소 기능
    public boolean chargeCancel(int mno){
        PaymentDto dto = paymentDao.chargePrint(mno);
        dto.setPamount(-dto.getPamount());
        boolean result = paymentDao.chargeAdd(dto);
        if (result){
            PointLogDto pdto = new PointLogDto();
            pdto.setPlcomment("결제취소");
            pdto.setPlpoint(dto.getPamount());
            pdto.setMno(dto.getMno());
            pointLogService.pointLogAdd(pdto);
            int bonus = (int) (dto.getPamount() * 0.05);
            PointLogDto pdto2 = new PointLogDto();
            pdto2.setPlcomment("충전보너스");
            pdto2.setMno(dto.getMno());
            pdto2.setPlpoint(bonus);
            pointLogService.pointLogAdd(pdto2);
        }// if end
        return result;
    }// func end

}// class end
