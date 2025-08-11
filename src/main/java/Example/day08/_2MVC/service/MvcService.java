package Example.day08._2MVC.service; // 패키지명

import Example.day08._2MVC.model.dao.MvcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // [1] Service 빈 등록
public class MvcService { // class start
    @Autowired // [2] Repository(dao) 빈 주입
    private MvcDao mvcDao;

    public void method(){
        System.out.println("MvcService.method"); // soutm 확인
        mvcDao.method(); // 리포지토리(다오)의 메소드 호출
    }// func end

}// class end
