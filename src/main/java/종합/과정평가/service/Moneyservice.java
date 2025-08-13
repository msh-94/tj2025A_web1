package 종합.과정평가.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.과정평가.model.dao.MoneyDao;

import java.util.List;
import java.util.Map;

@Service
public class Moneyservice {// class start
    // dao 불러오기
    private final MoneyDao moneyDao;
    @Autowired
    public Moneyservice(MoneyDao moneyDao){
        this.moneyDao = moneyDao;
    }

    // 회원 매출조회 화면
    public List<Map<String,Object>> salesPrint(){
        List<Map<String,Object>> list = moneyDao.salesPrint();
        return list;
    }// func end

}// class end
