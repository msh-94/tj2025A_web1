package Example.day03; // 패키지명

// AppStart : 스프링 실행과 동시에 같은패키지/하위패키지내 모든 컴포넌트 스캔 자동 빈(객체)등록

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller // 스프링에게 해당 클래스는 Controller 입니다 알림
// 어노테이션이란 ? 택배상자안에 있는 실질적인 내용물이 아닌 , 택배상자 앞에 붙인 '유리 취급주의'
// + HTTP(웹통신) 지원 + @Component 포함 ( @SpringBootApplication 가 스캔하는 대상 )
@RestController // @Controller( + @Component ) + @ResponseBody
public class RestController1 {// class start
    // 싱글톤 생략 : @Component 사용했기 때문에

    @GetMapping("/day03") // HTTP(웹 통신 규약) 중에서 'GET' METHOD 사용 , baseUrl 뒤로  자원URL 정의
    // url : http://localhost:8080/day03
    // Whitelabel Error Page : 요청은 정상이지만 , 응답은 없다.
    // * Talend API : 브라우저(주소입력창) 에서 HTTP 웹주소 입력은 GET 방식만 지원한다.
    // @ResponseBody // HTTP 요청에 따른 처리후 응답을 자바 타입에서 HTTP 타입으로 *자동변환* 주로 JSON(자바스크립트객체)
    // --> 현재 클래스 위에 Controller 가 @RestController 이면 생략 가능
    public String method1(){
        return "자바에서 보내온 메시지";
    }// func end


}// class end
