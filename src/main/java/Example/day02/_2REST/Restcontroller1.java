package Example.day02._2REST; // 패키지명

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller // 해당 클래스에 @Controller 어노테이션 주입
// 1. @Component : Spring 컨테이너(메모리) 에 been(객체)를 등록/생성 한다 < 싱글톤 대신에 사용 >
// 2. Spring Controller 는 기본적으로 HTTP(웹 서블릿) 통신 지원한다.
public class Restcontroller1 { // class start
    // 싱글톤 생략 : @Controller -> @Component 포함되서 자동으로 싱글톤 처럼 하나의 객체를 만들어준다.

    // REST 란 ? CRUD 기능을 HTTP 로 제공하는 아키텍쳐/기술/구조
    // Spring REST 란 ? @PostMapping , @GetMapping , @PutMapping , @DeleteMapping 등등 제공하므로써 웹기술 제공
    // REST 테스터 프로그램 : Talend API Tester - Free Edition
        // 1. 크롬실행
        // 2. https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ko&utm_source=ext_sidebar
        // 3. ( 크롬에 추가 )
        // 4. 크롬 상단에 주소입력창 오른쪽에 즐겨찾기 아이콘 옆에 조각(아이콘) 클릭하면 'Talend API Tester' 클릭
    // 1) 등록 : CREATE -> @PostMapping
    @PostMapping    // Talend API : [Method] POST , [Scheme] : http://localhost:8080 , 주의할점 : https 가 아닌 http
    public void 등록하기(){
        System.out.println("Restcontroller1.등록하기"); // soutm 자동완성
    }// func end
    // 2) 조회 : READ -> @GetMapping
    @GetMapping     // Talend API : [Method] GET , [Scheme] : http://localhost:8080 , 주의할점 : https 가 아닌 http
    public void 조회하기(){
        System.out.println("Restcontroller1.조회하기");
    }// func end
    // 3) 수정 : UPDATE -> @PutMapping
    @PutMapping     // Talend API : [Method] PUT , [Scheme] : http://localhost:8080 , 주의할점 : https 가 아닌 http
    public void 수정하기(){
        System.out.println("Restcontroller1.수정하기");
    }// func end
    // 4) 삭제 : DELETE -> @DeleteMapping
    @DeleteMapping  // Talend API : [Method] DELETE , [Scheme] : http://localhost:8080 , 주의할점 : https 가 아닌 http
    public void 삭제하기(){
        System.out.println("Restcontroller1.삭제하기");
    }// func end

}// class end
