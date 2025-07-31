package Example.day01; // 패키지명

import Example.day01.controller.BoardService;
import Example.day01.model.dto.BoardDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class AppStart { // class start
    public static void main(String[] args) { // main start

        System.out.println("자바실행");

        // BoardService 10 : view 제외한 동일한 구조
        // Gradle [라이브러리등록] "mysql=connector-j-9.3.0.jar" 파일 오른쪽
        // Gradle 환경 : build.gradle 파일내 runtimeOnly 'com.mysql:mysql-connector-j' 코드가 필요하다.

        // 1. 20250723 등록 테스트
        boolean result = BoardService.getInstance().boardWriter("테스트내용","강사");
        System.out.println( result );

        // 2. 20250723 전체조회 테스트
        ArrayList<BoardDto> result2 = BoardService.getInstance().boardPrint();
        System.out.println( result2 );

        // Spring 환경 실행
        SpringApplication.run(AppStart.class);

    }// main end
}// class end
