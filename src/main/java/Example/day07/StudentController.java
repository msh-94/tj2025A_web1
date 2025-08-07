package Example.day07; // 패키지명

import org.springframework.web.bind.annotation.*;

// @ : 어노테이션 이란? 추가적인 정보를 제공하는 메타데이터 역할 , 실질적인 기능(스프링)
@RestController // @Controller( + @Component ) + @ResponseBody
// @Component : 스프링 컨테이너(메모리)에 빈(객체) 등록/생성 , 싱글톤과 비슷한 역할
// @Controller : HTTP 요청 과 응답 매핑/연결
// @ResponseBody : HTTP 응답 자료의 *자동* (JSON)타입변환
@RequestMapping("/student")
// @RequestMapping( "/URL" ) : 지정한 클래스내 모든 메소드들의 공통 url
public class StudentController { // class start
    // 1. 저장 요청
    @PostMapping("/save") // localhost:8080/student/save
    // @PostMapping : HTTP 요청 중에 method 가 Post 인 요청 매핑
    // ("/URL") : HTTP 주소 만들기/정의
    public boolean save(@RequestBody StrudentDto strudentDto){
        System.out.println("StudentController.save"); // soutm
        return false;
    }// func end

    // 2. 전체 조회 요청
    @GetMapping("/find") // localhost:8080/student/find
    // @GetMapping : HTTP 요청 중에 method 가 Get 인 요청 매핑
    // ("/URL") : HTTP 주소 만들기/정의
    public void find (){
        System.out.println("StudentController.find");
    }// func end

}// class end
