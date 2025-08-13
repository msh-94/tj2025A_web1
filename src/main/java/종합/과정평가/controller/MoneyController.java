package 종합.과정평가.controller; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 종합.과정평가.service.Moneyservice;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/money")
public class MoneyController {//class start
    // service 불러오기
    private final Moneyservice moneyservice;
    @Autowired
    public MoneyController(Moneyservice moneyservice){
        this.moneyservice = moneyservice;
    }

    // 회원 매출조회 화면
    @GetMapping
    public List<Map<String,Object>> salesPrint(){
        List<Map<String,Object>> list = moneyservice.salesPrint();
        return list;
    }// func end

}// class end
